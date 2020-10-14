package cn.InputAndOutput;

import java.io.*;

/**
 * 转换流使用
 * InputStreamReader isr = new InputStreamReader();
 * OutputStreamWriter osw = new OutputStreamWriter();
 * 用不同的编码格式读取文件，并用不同的编码格式写入到另一个文件中
 * 分别用不同的编码格式读取对应编码格式的文件
 */

public class ZhuanHuanLiuDemo {
    public static void main(String[] args) throws IOException {
        // characterDemo();

        read_Unicode();
        System.out.println("**************&&&&&&&&&&*****************");
        read_utf_8();

    }

    private static void read_utf_8() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\IDEAA\\IODemo\\UTF-8格式.txt"), "utf-8");
        int len = 0;
        while ((len = isr.read()) != -1) {
            System.out.println((char) len);
        }
        isr.close();
    }

    private static void read_Unicode() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\IDEAA\\IODemo\\Unicode格式.txt"), "unicode");
        int len = 0;
        while ((len = isr.read()) != -1) {
            System.out.println((char) len);
        }
        isr.close();
    }

    private static void characterDemo() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("D:\\IDEAA\\IODemo\\Unicode格式.txt"), "Unicode");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\IDEAA\\IODemo\\UTF-8格式.txt", true), "utf-8");

        int len = 0;
        while ((len = isr.read()) != -1) {
            osw.write(len);
        }
        osw.close();
        isr.close();
    }

}
