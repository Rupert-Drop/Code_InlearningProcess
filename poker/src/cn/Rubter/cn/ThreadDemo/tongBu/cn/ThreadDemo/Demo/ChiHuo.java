package cn.Rubter.cn.ThreadDemo.tongBu.cn.ThreadDemo.Demo;

/**
 * 吃货线程
 */
public class ChiHuo extends Thread {
    private BaoZi bz;

    public ChiHuo(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 5) {
            synchronized (bz) {//线程通信，，保证线程安全
                if (bz.flag == false) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("吃包子-----ing！");
                //被唤醒后执行
                try {
                    Thread.sleep(2000);
                    System.out.println("老板再来点！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bz.flag = false;
                bz.notify();
                count++;
                System.out.println("*************#######************");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
