package cn.Rubter.cn.ThreadDemo.tongBu.cn.ThreadDemo.Demo;

/**
 * 包子铺线程
 */
public class BaoZiPu extends Thread {
    private BaoZi bz;

    public BaoZiPu(BaoZi bz) {
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        while (count < 5) {
            System.out.println(count);
            synchronized (bz) {//线程同步
                //设置线程任务
                if (bz.flag == true) {//有包子,包子铺进程等待
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    if (count % 2 == 1) {
                        bz.pi = "薄皮";
                        bz.xian = "牛肉";
                    } else if (count % 2 == 0) {
                        bz.pi = "冰皮";
                        bz.xian = "猪肉大葱";
                    }
                    System.out.println(bz.pi + bz.xian + "包子正在加紧制作中");
                    Thread.sleep(2000);
                    //唤醒吃货线程，开始执行
                    bz.notify();
                    bz.flag = true;
                    count++;
                    System.out.println(bz.pi + bz.xian + "包子来了，慢用");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
