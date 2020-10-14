package cn.InputAndOutput;

import jdk.nashorn.internal.ir.WhileNode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 * 字符缓冲输入流
 */
public class CopyDemoReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\bufferFile"));
        String line;

        while ((line = br.readLine()) != null) {
            System.out.println(line);

        }
        br.close();
    }
}
