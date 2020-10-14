package cn.InputAndOutput;

import java.io.*;

/**
 * 字节缓冲输出流
 */
public class CopyDemo0OutputStr {
    public static void main(String[] args) throws IOException {

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\bufferFile", true));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\bufferFile"));
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes);
            //  bos.write('\n');
        }
        // bos.write(bytes);
        bos.close();
    }
}
