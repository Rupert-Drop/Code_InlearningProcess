package cn.serverDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端
 * 服务器阻塞解决方法
 * socket.shutdown。。。。()方法;
 */

public class ServerDemo01 {
    public static void main(String[] args) throws IOException {
        //创建一个服务器，并设置其端口号
        ServerSocket serverSocket = new ServerSocket(9999);
        //利用服务器对象获取客户端对象
        Socket socket = serverSocket.accept();
        //再利用客户端对象获取到输入流对象
        InputStream is = socket.getInputStream();

        /*套用读取数据的代码块*/
        byte[] bytes = new byte[1024];//提高读的速度
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));
        //创建一个网络输出流，向客户端回写信息
        OutputStream os = socket.getOutputStream();
        os.write("已收到，over，over".getBytes());

        //释放资源
        socket.close();//关闭客户端的连接
        serverSocket.close();//关闭服务器
    }
}
