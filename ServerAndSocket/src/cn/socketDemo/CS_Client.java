package cn.socketDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * 客户端
 * 文件上传案例
 * 从客户端本地读-->写入网络流中
 * 客户端本地路径("D:\\IDEAA\\ServerAndSocket\\src\\clientDile"));
 * 必须先开启服务器再启动客户端
 * 上传完文件就打印结束标记，在客户端执行socket.shutdownOutput();
 */
public class CS_Client {
    public static void main(String[] args) throws IOException {
        //创建客户端对象，并指定要连接的服务器的端口号
        Socket socket = new Socket("127.0.0.1", 9999);

/************************************此为上传文件代码****************************************************/
        //创建本地输入流对象，并指定要读取的文件路径
        FileInputStream fis = new FileInputStream("D:\\\\IDEAA\\\\ServerAndSocket\\\\src\\socketFile\\p5.jpg");
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            //获取网络输出流对象，       调用网络流对象的写方法写入到网络流中
            socket.getOutputStream().write(bytes, 0, len);
        }
        //为解决阻塞问题，调用shutdown。。。（）方法，打印结束标记以结束输出流
        socket.shutdownOutput();
/************************************此为上传文件代码****************************************************/

/************************************此为获取服务器回写数据代码****************************************************/
        //获取网络输入流
        InputStream is = socket.getInputStream();
        while ((len = is.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));

        }

/************************************此为获取服务器回写数据代码****************************************************/
        //释放资源
        fis.close();
        socket.close();

    }
}
