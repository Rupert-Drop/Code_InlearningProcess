package cn.socketDemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * c/s模式
 * client/server
 * 客户端
 * 使用socket对象的accept方法，获取网络流对象
 */
public class SocketDemo01 {
    public static void main(String[] args) throws IOException {
        //创建客户端对象，
        Socket socket = new Socket("127.0.0.1", 9999);//并指定服务器的IP地址和端口号
        //创建一个输出流，往服务端写数据“请求访问”
        OutputStream os = socket.getOutputStream();
        os.write("请求访问服务器".getBytes());//向服务器发送数据

        //创建一个网络输入流，读从服务端发送的数据
        InputStream is = socket.getInputStream();
        byte[] bytes = new byte[1024];//提高读的速度
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));

        //关闭客户端
        socket.close();
    }
}
