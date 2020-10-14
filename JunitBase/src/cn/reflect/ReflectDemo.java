package cn.reflect;

import cn.Domin.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;

/**
 * 三种获取类对象的方法演示
 * 1.class。forName
 * 2.类名。class
 * 3.类对象。getClass（）方法
 * 获取类中的成员变量，
 * 对象.setAccessible(true) 暴力反射，忽略权限修饰符作用
 * 获取类中的方法
 */

public class ReflectDemo {
    public static void main(String[] args) throws Exception {

        /*Demo1*/
        System.out.println("*******获取全类名********");
        //1.class。forName
        Class person = Class.forName("cn.Domin.Person");
        //类名。class
        Class nam = Person.class;
        //类对象。getClass（）方法
        Person ps = new Person();
        Class na = ps.getClass();
        System.out.println(person);
        System.out.println(nam);
        System.out.println(na);
        System.out.println();


        /*Demo2*/
        System.out.println("******获取成员变量*******");
        Field[] fields = person.getFields();//获取所有被public修饰的成员变量，并返回一个field类型的数组
        Field[] declaredFields = person.getDeclaredFields();//获取所有的成员变量，并。。。。
        System.out.println("fields数量：" + fields.length);
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println();
        System.out.println("declaredFields数量：" + declaredFields.length);
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        /*成员变量的操作*/
        Field d = person.getDeclaredField("d");
        d.setAccessible(true);//暴力反射，忽略权限修饰符作用
        Person p = new Person();
        Object o = d.get(p);
        System.out.println(p);
        d.set(p, "我是p对象的d成员变量");
        System.out.println(p);

        /*Demo3*/
        System.out.println("******获取构造方法********");
        Constructor constructor = person.getConstructor(String.class, int.class, String.class, String.class, String.class, String.class);
        Object o1 = constructor.newInstance("Rubter", 22, "a", "a", "a", "a");//利用多参构造函数创建对象
        System.out.println(o1);
        System.out.println("空参构造--------");
        Object o2 = person.newInstance();//直接利用类对象调用空参构造创建对象
        System.out.println(o2);




        /*Demo4*/
        System.out.println("*********获取方法**********");
        Method[] methods = person.getMethods();//得到的是public修饰的方法，包括其父类中的方法，methods得到的方法数22
        Method[] declaredMethods = person.getDeclaredMethods();//得到的是所有权限修饰符的方法，declaredMethods得到的方法数:16
        System.out.println("methods得到的方法数" + methods.length);
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println();
        System.out.println("-------------");
        System.out.println("declaredMethods得到的方法数:" + declaredMethods.length);
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println();
        System.out.println();
        System.out.println();
        /*执行方法*/
        Method eat = person.getMethod("eat");//获取到指定的方法对象
        /*Method run = person.getMethod("run");//无法通过，因为run方法被private修饰，并且使用暴力反射也无法获取
        run.setAccessible(true);*/
        Method run = person.getDeclaredMethod("run");//1.使用正确的获取方法
        run.setAccessible(true);//2.暴力反射
        eat.invoke(o1);

        run.invoke(o1);//1.&&2.同时成立才能正确输出

    }
}
