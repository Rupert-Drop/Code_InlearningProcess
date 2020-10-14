package cn.InputAndOutput;

import java.io.*;

/**
 * 字节输入输出流案例
 * 文件复制:D:\IDEAA\IODemo\src\cn\InputAndOutput\a.txt
 * 均采用了绝对路径，亦可使用相对路径
 * 测试程序耗时时间：
 * 定义两个long类型变量接收 = System.currentTimeMillis()方法，做差即可
 */
public class CopyDemo {
    public static void main(String[] args) throws IOException {
        creatShow();//创建多级文件夹
        copy();//复制文件方法
    }

    private static void creatShow() throws IOException {
        File file = new File("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\a");
        file.mkdirs();//创建多级文件夹a
        File file1 = new File("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\b\\b.txt");
        file1.createNewFile();//创建文件b.txt
    }

    /**
     * 复制文件案例：
     * 练习使用字节输入输出流
     *
     * @return 复制成功与否
     * @throws IOException
     */
    private static void copy() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\a\\p2.jpg");//输入流：读
        FileOutputStream fos = new FileOutputStream("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\b\\p2.jpg");//输出流：写
        byte[] bytes = new byte[1024];//可理解为读取字节文件的滑动窗口，最好设置为1024的整数倍

        //复制文件a中内容到b文件
        int len = 0;
        //设置开始时间
        long start = System.currentTimeMillis();
        while ((len = fis.read(bytes)) != -1) {//注意：此处为(len = fis.read(bytes))!!!!!!不能写作fis.read(bytes)！=-1；
            fos.write(bytes, 0, len);//bytes,0,len:每次写bytes数组长度个字节，从0开始；
        }
        //设置结束时间
        long ending = System.currentTimeMillis();
        //输出总耗时：
        System.out.println("复制文件共耗时：" + (ending - start) + "毫秒");
       /* //输出b文件内容
        FileInputStream fis1 = new FileInputStream("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\b\\p2.jpg");
        fis1.read(bytes);//存到bytes中，缓冲作用*/
        //  System.out.println(new String(bytes));
       /* System.out.println(len);
        System.out.println(bytes);
        System.out.println(bytes.toString());
        System.out.println(new String(bytes));*/
        //  fis1.close();
        fos.close();
        fis.close();
    }

}
