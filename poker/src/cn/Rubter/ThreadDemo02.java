package cn.Rubter;

/**
 * 执行新线程
 * 方法二：
 * 调用实现了Runnable的方法完成新线程的启用
 */

public class ThreadDemo02 {
    public static void main(String[] args) {
        //step1:调用ImplementsRunnable方法,创建对象
        //Runnable runnable = new ImplementsRunnable();//体现了多态
        ImplementsRunnable runnable = new ImplementsRunnable();
        //step2:创建thread对象,
        Thread thread = new Thread(runnable);//传入要执行的线程对象

        //step3：调用start方法，开始新线程
        thread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("******调用ImplementsRunnable的main方法******");
        }

    }
}
