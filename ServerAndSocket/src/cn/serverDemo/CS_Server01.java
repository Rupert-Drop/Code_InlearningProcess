package cn.serverDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * 对CS_Server的优化，开启新线程
 * 上传完文件就打印结束标记，在客户端执行socket.shutdownOutput();
 */
public class CS_Server01 {
    public static void main(String[] args) throws IOException {
        //创建服务器对象，并设置端口号
        ServerSocket server = new ServerSocket(9999);
        //获取socket对象

        while (true) {//让服务器一直处于监听状态
            Socket socket = server.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取网络输入流对象
                        InputStream is = socket.getInputStream();
                        //获取文件对象，并判断文件是否存在
                        File file = new File("D:\\\\IDEAA\\\\ServerAndSocket\\\\src\\serverFile");
                        if (!file.exists()) {
                            file.mkdirs();//若不存在则创建文件
                        }
                        //获取本地输出流
                        FileOutputStream fos = new FileOutputStream(file + "\\" + new Random().nextInt(100) + ".jpg");
                        //测试代码执行的标记时间
                        long start = System.currentTimeMillis();
                        //套用流对象的读写代码
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = is.read(bytes)) != -1) {//用网络输入流对象获取网络输出流中的文件
                            //将从网络输出流中获取到的文件保存到本地输出流
                            fos.write(bytes, 0, len);
                        }

                        /**************向客户端回写数据***************/
                        //获取网络输出流
                        // socket.getOutputStream().write("上传成功".getBytes());
                        socket.getOutputStream().write(("上传文件成功,共花费" + ((System.currentTimeMillis() - start) + "毫秒")).getBytes());
                        //释放资源
                        fos.close();
                        socket.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }//每上传一个文件，开启一个新线程
            }).start();
        }
    }
}
