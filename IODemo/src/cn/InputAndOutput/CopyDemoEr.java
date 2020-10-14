package cn.InputAndOutput;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 字符流案例:
 * 使用相对路径
 * flush：刷新
 * close：先刷新再关闭
 * JDK1.7之后可不用写finally部分代码
 */

public class CopyDemoEr {
    public static void main(String[] args) {
        try (FileWriter fw = new FileWriter("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\b\\c", true);
             FileReader fr = new FileReader("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\b\\b.txt")) {//append:允许续写
            char[] chars = new char[8];
            int len = 0;
            while ((len = fr.read(chars)) != -1) {
                fw.write(chars);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
