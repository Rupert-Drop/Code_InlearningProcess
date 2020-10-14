package cn.InputAndOutput;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * 打印流，默认输出到控制台
 * ，改变流向输出到D:\IDEAA\IODemo\src\personList中
 */
public class SystemOutDemo {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("我在控制台");
        PrintStream ps = new PrintStream("D:\\IDEAA\\IODemo\\src\\systemDemo");//创建打印流对象
        System.setOut(ps);//更换打印的目的地
        System.out.println("我改变了路径，输出到文件中");
        ps.close();
    }
}
