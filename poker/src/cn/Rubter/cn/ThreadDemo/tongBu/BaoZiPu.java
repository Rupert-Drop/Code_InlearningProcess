package cn.Rubter.cn.ThreadDemo.tongBu;

public class BaoZiPu extends Thread {
    //在成员变量位置创建一个包子变量
    private BaoZi baoZi;

    //使用带参构造方法,为包子变量赋值1
    public BaoZiPu(BaoZi baoZi) {
        this.baoZi = baoZi;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (baoZi) {
                //判断包子的flag
                //true:此时在吃包子，不必生产
                if (baoZi.flag == true) {
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //被唤醒后执行
                //实现两种不同的包子
                if (count % 2 == 0) {
                    baoZi.pi = "薄皮";
                    baoZi.xian = "素馅";

                } else if (count % 2 == 1) {
                    baoZi.pi = "冰皮";
                    baoZi.xian = "肉馅";

                }
                System.out.println(baoZi.pi + baoZi.xian + "包子正在准备");
                try {
                    Thread.sleep(1000);
                    baoZi.notify();
                    System.out.println(baoZi.pi + baoZi.xian + "包子可以吃了");
                    Thread.sleep(2000);
                    count++;
                    baoZi.flag = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
