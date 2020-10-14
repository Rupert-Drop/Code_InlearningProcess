package cn.InputAndOutput;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 字节缓冲输入流
 */

public class CopyDemo0InputStr {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\bufferFile"));
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            // System.out.println(len);
            bis.read(bytes);
            System.out.println(new String(bytes));
        }

        bis.close();

    }
}
