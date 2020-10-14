package cn.InputAndOutput;

import sun.awt.SunHints;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 利用map集合对诗句乱序排序
 */
public class MapAndBufferDemo {
    public static void main(String[] args) throws IOException {
        //创建一个HashMap集合对象，存储每行文本的序号
        HashMap<String, String> map = new HashMap<String, String>();
        //创建字符缓冲输入流对象，构造方法中绑定字符输入流
        BufferedReader br = new BufferedReader(new FileReader("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\bufferFile"));
        //创建字符缓冲输出流对象，构造方法中绑定字符输出流
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\IDEAA\\IODemo\\src\\cn\\InputAndOutput\\bufferFile", true));
        //使用字符缓冲输入流中的方法readline（）方法，逐行读取文本
        String line;
        //读数据
        while ((line = br.readLine()) != null) {
            //对读取到的文本进行切割，获取行中的序号和文本内容
            String[] arr = line.split("\\.");//切割读取到的数据
            //把切割好的序号和文本的内容存储到hashmap集合中
            map.put(arr[0], arr[1]);//装载集合

            // System.out.println("ary_"+arr[0]);
            //System.out.println("长度"+arr.length);
        }

        //遍历Hashmap集合，获取每一个键值对
        for (String key : map.keySet()) {//keyset方法，将建值封装为一个数组
            String value = map.get(key);
            line = key + "." + value;
            bw.write(line);
            bw.newLine();
        }
        System.out.println(map.keySet());
        System.out.println(map);
        br.close();
        bw.close();
    }
}
