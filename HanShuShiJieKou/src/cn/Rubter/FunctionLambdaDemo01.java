package cn.Rubter;

import jdk.nashorn.internal.ir.IfNode;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 常用的几个函数式接口
 * 函数式接口定义：有且仅有一个抽象方法
 */
public class FunctionLambdaDemo01 {
    public static void main(String[] args) {//主方法，分别调用不同的函数式接口
        /*
         *生产者，供应商，返回一个泛型参数所指定的类型对象数据
         **/
        supplierDemo(() -> {
            return "执笔画清眸";
        });
        //优化后lambda表达式
        String s = supplierDemo(() -> "supplierDemo() -> " + "执笔画清眸");
        System.out.println(s);
        System.out.println("************靓丽的分割线****************");
/***************************************************************************************************************/
        /*
         *消费者，用来消费一个数据，用来对该数据进行加工处理
         **/
        consumerDemo("执笔画清眸", (String string) -> {
            System.out.print("consumerDemo()->");
            System.out.println(string);
        });
        //优化
        consumerDemo("优化后：执笔画清眸", (string) -> System.out.println(string));

        /*默认方法的调用*/
        consumerDefault(10,
                (in1) -> {
                    System.out.println(11 + in1);
                },
                (in2) -> {
                    System.out.println("consumerDefault2->" + 12 + in2);//此处由于拼接字符串，转换为了string类型
                });
        System.out.println("************靓丽的分割线****************");

/***************************************************************************************************************/
        /*
         *断言，用来对一个指定类型的数据进行判断
         **/
        boolean b = predicateDemo("浅笑依然", (String str) -> {
            return str.startsWith("浅");
        });
        //优化
        boolean b1 = predicateDemo("落落大方", (str) -> str.startsWith("大方"));
        System.out.println("predicateDemo() ->" + b);
        System.out.println("优化后predicateDemo() ->" + b1);

        /*默认方法的调用*/
        System.out.println("predicate接口的默认方法：");
        boolean b2 = predicateDefault1("和敬清寂",//自结：分别调用了两次test方法，对两次结果采用与运算
                (if1) -> {
                    return if1.startsWith("和");
                },
                (if2) -> {
                    return if2.endsWith("寂");
                });

        boolean b3 = predicateDefault2("我自风情万种，与世无争",
                (if1) -> {
                    return if1.startsWith("你");
                },
                (if2) -> {
                    return if2.endsWith("争");
                });
        boolean b4 = predicateDefault3("鲁伯特之泪", (if1) -> {
            return if1.endsWith("类");
        });
        System.out.println("and方法:" + b2 + " " + "or方法:" + b3 + " " + "negate方法:" + b4);
        System.out.println("************靓丽的分割线****************");

/***************************************************************************************************************/
        /*
         *  用来将一个类型的数据转换为指定的数据类型
         **/
        functionDemo("婉莹", (fun) -> {
            People people = new People(fun);
            System.out.println(people);
            return people;
        });

    }

    /**
     * @param supplier
     * @return
     */
    private static String supplierDemo(Supplier<String> supplier) {//生产者，供应商，返回一个泛型参数所指定的类型对象数据
        //调用get（）方法
        return supplier.get();
    }

    /**
     * @param str
     * @param consumer
     */
    private static void consumerDemo(String str, Consumer<String> consumer) {//消费者，用来消费一个数据，用来对该数据进行加工处理
        //调用了consumer接口的accept（）方法
        consumer.accept(str);
    }

    private static void consumerDefault(Integer a, Consumer<Integer> con1, Consumer<Integer> con2) {
        //调用了consumer接口的accept（）方法,还有默认方法中的andThen()方法
        con1.andThen(con2).accept(a);
    }

    /**
     * @param str
     * @param pre
     * @return
     */
    private static boolean predicateDemo(String str, Predicate<String> pre) {//断言，用来对一个指定类型的数据进行判断
        //调用抽象方法test（）
        return pre.test(str);

    }

    private static boolean predicateDefault1(String str, Predicate<String> a, Predicate<String> b) {
        return a.and(b).test(str);
    }

    private static boolean predicateDefault2(String str, Predicate<String> a, Predicate<String> b) {
        return a.or(b).test(str);
    }

    private static boolean predicateDefault3(String str, Predicate<String> a) {
        return a.negate().test(str);
    }

    /**
     *
     */
    private static void functionDemo(String name, Function<String, People> fun) {//用来将一个类型的数据转换为指定的数据类型
        fun.apply(name);
    }
}
