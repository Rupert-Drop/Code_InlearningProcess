package cn.Rubter.cn.ThreadDemo.tongBu;

public class chiHuo extends Thread {
    private BaoZi baoZi;

    public chiHuo(BaoZi baoZi) {
        this.baoZi = baoZi;

    }

    @Override
    public void run() {
        while (true) {
            synchronized (baoZi) {
                if (baoZi.flag == false) {//此时没有包子，吃货进入等待
                    try {
                        baoZi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //被包子铺老板唤醒后执行吃包子
                try {
                    System.out.println("吃" + baoZi.pi + baoZi.xian + "包子中");
                    Thread.sleep(3000);
                    //吃完后唤醒包子铺老板，让他开始做包子
                    baoZi.flag = false;
                    baoZi.notify();
                    System.out.println(baoZi.pi + baoZi.xian + "包子已被吃完,老板再来点");
                    System.out.println("*****************************");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
