package cn.InputAndOutput;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * Properties演示案例
 */
public class propDemo {
    public static void main(String[] args) throws IOException {
        creatProp();
        Demo();
    }

    private static void creatProp() throws IOException {
        //创建一个Properties集合，并存入内容
        Properties prop = new Properties();
        prop.setProperty("花开有时", "执笔画清眸");
        prop.setProperty("桃花", "三月");
        prop.setProperty("荷花", "六月");
        prop.setProperty("菊花", "九月");
        prop.setProperty("梅花", "腊月");

        //创建一个输入流
        FileWriter fw = new FileWriter("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\b\\c");
        prop.store(fw, "PropertyDemo-creatData");
        fw.close();
    }

    private static void Demo() throws IOException {
        Properties prop = new Properties();

        //读取并输出Propertie集合内容
        /*FileReader fr = new FileReader("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\b\\c");
        prop.load(fr);//读取文件内容并存到prop的Property集合中*/

        /*使用匿名内部类加载文件进集合*/
        prop.load(new FileReader("D:\\\\IDEAA\\\\IODemo\\\\src\\\\cn\\\\InputAndOutput\\\\b\\\\c"));

        Set<String> set = prop.stringPropertyNames();//得到key值的集合
        for (String key : set) {
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }

        /*fr.close();*/
    }
}
