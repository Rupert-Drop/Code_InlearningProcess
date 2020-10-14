package cn.Rubter;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * 流式编程练习
 */
public class StreamMind {
    public static void main(String[] args) {//主方法，分别调用不同的Stream内部方法
        String[] str = {"喜羊羊", "美羊羊", "灰太狼", "红太狼", "懒羊羊", "沸羊羊", "慢羊羊", "Rubter", "执笔画清眸"};
        ArrayList<String> arr = new ArrayList<>();
        arr.add("一个人的气质里,");
        arr.add("藏着他走过的路,");
        arr.add("读过的书，");
        arr.add("爱过的人，");
        arr.add("和他所向往的未来。");
        arr.add("——执笔画清眸");

        forEachDemo(str);
        System.out.println("*******************华丽的分割线*********************");
        filterDemo(str);
        System.out.println("*******************华丽的分割线*********************");
        mapDemo(str);
        System.out.println("*******************华丽的分割线*********************");
        countDemo(arr);
        System.out.println("*******************华丽的分割线*********************");
        limitDemo(arr);
        System.out.println("*********华丽的分割线**********");
        skipDemo(arr);
        System.out.println("*******************华丽的分割线*********************");
        concatDemo(arr, str);
    }

    /**
     * 将两个流对象拼接成一个新的流对象
     *
     * @param arr
     * @param str
     */
    private static void concatDemo(ArrayList<String> arr, String[] str) {
        Stream<String> str1 = arr.stream();
        Stream<String> str2 = Stream.of(str);
        Stream.concat(str1, str2).forEach((name) -> System.out.println(name));

    }

    /**
     * 流对象的skip方法
     * 获取到源流对象的去除前n个元素的流对象
     *
     * @param arr
     */
    private static void skipDemo(ArrayList<String> arr) {
        arr.stream().skip(3).forEach((name) -> System.out.println(name));
    }

    /**
     * 流对象的limit方法
     *
     * @param arr
     */
    private static void limitDemo(ArrayList<String> arr) {
        arr.stream().limit(3).forEach((name) -> System.out.println(name));
    }

    /**
     * 流对象的 count方法
     *
     * @param arr
     */
    private static void countDemo(ArrayList<String> arr) {
        long count = arr.stream().count();
        System.out.println("arr集合长度：" + count);
    }

    /**
     * 流对象的map方法
     *
     * @param str
     */
    private static void mapDemo(String[] str) {
        Stream<People> peopleStream = Stream.of(str).map((name) -> {
            return new People(name);
        });
        peopleStream.forEach((people) -> {
            System.out.println(people);
        });

    }

    /**
     * 流对象的 fileter方法
     *
     * @param str
     */
    private static void filterDemo(String[] str) {//
        Stream<String> str1 = Stream.of(str);
        System.out.println("filterDemo:");
        Stream<String> str2 = str1.filter((name) -> {
            return name.endsWith("狼");
        });
        str2.forEach((name) -> {
            System.out.println(name);
        });
    }

    /**
     * 流对象的 forEach方法
     *
     * @param str
     */
    private static void forEachDemo(String[] str) {
        Stream<String> str1 = Stream.of(str);//把该数组转换成流对象
        System.out.println("forEachDemo:");//遍历流对象中的每一个元素
        str1.forEach((name) -> {
            System.out.println(name);//foreach调用了consumer（）方法,使用lambda表达式
        });

    }
}
