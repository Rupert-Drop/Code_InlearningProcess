package cn.Rubter.cn.ThreadDemo.tongBu;

/**
 * synchronized：(使)同步，在时间上一致，同速进行
 * Exception:一般情况以外的人(或事物);例外;规则的例外;例外的事物
 * 线程同步测试类（线程通信）
 * 包子铺案例
 * <p>
 * 顾客线程(消费者）：告知所需的包子数量，调用wait方法，放弃cpu的使用权，进入WAITING等待状态
 * 包子铺线程（生产者）：生产包子花费五秒生产包子。做好后，调用notify（通知）方法，唤醒顾客吃包子
 * <p>
 * 注意：
 * 两线程必须同步，且等待和唤醒只能有一个在执行
 * 同步使用的锁对象必须保证唯一且是同一个
 * 只有锁对象才能调用wait和notify方法
 * synchronized关键字解决线程通信问题
 * <p>
 * 执行结果：
 * 老板儿，拿五个包子呗！！
 * 得嘞，包子来喽！客官趁热吃
 * 老板，这包子真香!
 */

public class threadTest01 {
    public static void main(String[] args) {
        //创建锁对象，保证唯一性（自结：可理解为进程管理员）
        Object threadManager = new Object();
        //创建一个顾客线程（消费者）,
        // 使用extends Thread方法的匿名内部类实现
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    synchronized (threadManager) {
                        System.out.println("老板儿，拿五个包子呗！！");
                        //线程通信等待
                        try {
                            threadManager.wait();
                            System.out.println("老板，这包子真香!");
                            System.out.println("#######################");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

        //创建一个包子铺线程（生产者），
        // 使用implements Runnable完成线程的匿名内部类实现
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (threadManager) {
                        System.out.println("得嘞，包子来喽！客官趁热吃");
                        threadManager.notify();//通知唤醒当前等待中的线程
                        //threadManager.notifyAll();通知唤醒所有等待中的线程
                    }
                }
            }
        }).start();

    }
}
