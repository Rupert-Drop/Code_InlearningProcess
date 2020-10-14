package cn.Rubter;

/**
 * 执行新线程
 * 方法一：
 * 调用ExtendsThread利用第一种方法启用多线程
 */
public class ThreadDemo01 {
    public static void main(String[] args) {
        ExtendsThread et = new ExtendsThread("执笔画清眸");
        //设置线程的名字
        // et.setName("执笔画清眸");
        System.out.println(et.getName());
        et.start();
        for (int i = 0; i < 5; i++) {
            System.out.println("*****ExtendsThread执行的main主线程*****");
        }

    }
}
