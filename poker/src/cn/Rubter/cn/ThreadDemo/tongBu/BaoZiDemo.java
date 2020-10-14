package cn.Rubter.cn.ThreadDemo.tongBu;

/**
 * 多线程
 * 自结：
 * （类比）主线任务，支线任务
 * （类比）路与岔路口
 */
public class BaoZiDemo {
    public static void main(String[] args) {
        BaoZi baoZi = new BaoZi();//线程的管理员，任务的执行者，走路的 人
        new BaoZiPu(baoZi).start();//支线任务一
        new chiHuo(baoZi).start();//支线任务二
    }
}
