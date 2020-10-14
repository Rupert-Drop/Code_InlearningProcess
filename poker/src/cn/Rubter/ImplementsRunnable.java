package cn.Rubter;

/**
 * 多线程方式二：实现Runnable接口来达到多线程目的
 */

public class ImplementsRunnable implements Runnable {

    @Override
    public void run() {//完成接口中的run方法,在其中设置新线程的任务
        for (int i = 0; i < 20; i++) {
            System.out.println("*****已开劈新的堆内存，并利用其执行新的线程*****");
        }

    }
}
