package cn.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 利用反射实现
 * 一个可以创建任何实体类的对象，并执行任和方法的”框架“
 */
public class ClassDoDemo {
    public static void main(String[] args) throws Exception {
        Class<ClassDoDemo> cdd = ClassDoDemo.class;//获取到当前的类对象
        ClassLoader thisLoader = cdd.getClassLoader();//获取到当前类的类加载器
        InputStream resourceAsStream = thisLoader.getResourceAsStream("pro.properties");//返回一个读取对应文件的流对象
        Properties prop = new Properties();//创建Properties对象
        prop.load(resourceAsStream);//加载文件内容进Properties集合

//        得到pro文件中的数据
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        //利用反射，进行类的加载，对象的创建，方法的调用
        Class exceptClass = Class.forName(className);//根据类名获取对应的类
        Object o = exceptClass.newInstance();//调用空参构造，创建一个对象
        Method method = exceptClass.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(o);

    }
}
