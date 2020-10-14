package cn.Rubter.cn.ThreadDemo.tongBu;

/**
 * Runnable：可运行
 * current：
 * adj.
 * 现时发生的;当前的;现在的;通用的;流通的;流行的
 * n.
 * (海洋或江河的)水流;气流;电流;思潮;潮流;趋向
 */
public class PoolThread extends Thread implements Runnable {
    public PoolThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        System.out.println(this.getName() + "线程名");
        System.out.println("this:" + this);
        System.out.println("PoolThread.currentThread():" + PoolThread.currentThread());
        System.out.println("Thread.currentThread():" + Thread.currentThread());
    }
}
