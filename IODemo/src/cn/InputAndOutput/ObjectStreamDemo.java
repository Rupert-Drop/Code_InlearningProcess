package cn.InputAndOutput;

import java.io.*;
import java.util.ArrayList;

/**
 * 序列化与反序列化Demo（写对象，读对象的操作）
 * 要进行序列化与反序列化的类必须implements实现Serializable接口
 * transient 瞬态关键字和static关键字修饰的变量不参与序列化
 * private final static long SerialVersionUIDAdder = 1L;//自定义一个序列化ID,防止更改实体类后系统给的序列化ID不一样，产生冲突
 * readObject()方法除了抛出IO流异常之外，还会抛出ClassNotFoundException方法找不到异常
 */

public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //创建集合
        ArrayList<PerSon> people = new ArrayList<>();
        //创建对象
        people.add(new PerSon("张三", 16));
        people.add(new PerSon("李四", 17));
        people.add(new PerSon("王五", 18));
        // System.out.println(people);
        //调用序列化方法
        serializableDemo(people);
        //调用反序列化方法
        reSerializableDemo();

    }

    private static void serializableDemo(ArrayList<PerSon> people) throws IOException {//序列化方法
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\IDEAA\\IODemo\\src\\personList"));
        oos.writeObject(people);
        //释放资源
        oos.close();
    }

    private static void reSerializableDemo() throws IOException, ClassNotFoundException {//反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\IDEAA\\IODemo\\src\\personList"));
        //创建一个对象,并接收反序列化结果
       /* Object o =ois.readObject();
        //将Object 类型的集合强转为ArrayList类型
        ArrayList<PerSon> list = (ArrayList<PerSon>) o;*/
        ArrayList<PerSon> list = (ArrayList<PerSon>) ois.readObject();
        //使用增强for遍历输出集合中内容
        for (PerSon perSon : list) {
            System.out.println(perSon);
            System.out.println(perSon.getName() + perSon.getAge());
        }
        //释放资源
        ois.close();
    }
}
