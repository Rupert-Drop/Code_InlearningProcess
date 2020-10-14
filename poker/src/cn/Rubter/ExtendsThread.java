package cn.Rubter;

/**
 * 继承Thread类达到多线程的目的
 */
public class ExtendsThread extends Thread {
    public ExtendsThread() {

    }

    public ExtendsThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        //重写父类run方法，设置新线程任务
        for (int i = 0; i < 16; i++) {
            System.out.println("*****已开劈新的堆内存，并利用其执行新的线程*****");
        }
    }
}
