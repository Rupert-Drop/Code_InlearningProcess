package cn.InputAndOutput;

import java.beans.beancontext.BeanContext;
import java.io.*;

/**
 * 字符缓冲输出流
 */
public class CopyDemoWriter {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\bufferFile", true));
        BufferedReader br = new BufferedReader(new FileReader("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\bufferFile"));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();//特有方法，换行
        }
        br.close();
        bw.close();
    }

}
