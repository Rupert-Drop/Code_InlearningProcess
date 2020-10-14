package cn.Rubter.cn.ThreadDemo.tongBu.cn.ThreadDemo.Demo;

public class Test {
    public static void main(String[] args) {
        BaoZi bz = new BaoZi();
        new BaoZiPu(bz).start();
        new ChiHuo(bz).start();
    }
}
