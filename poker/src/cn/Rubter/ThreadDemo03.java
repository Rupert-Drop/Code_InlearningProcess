package cn.Rubter;

/**
 * 匿名内部类的实现方式：两种；
 * 方法一：extendsThread
 * 方法二：implementsRunnable
 */
public class ThreadDemo03 {
    public static void main(String[] args) {
        /**
         * 方法二：
         * ImplementsRunnable匿名内部类创建新线程
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println("ImplementsRunnable内部类");
                }
            }
        }).start();

        /**
         * 方法一：
         * extendsThread匿名内部类创建新线程
         */
        new Thread() {//利用多态创建一个匿名内部类
            @Override
            public void run() {//重写父类的run方法，设置新线程任务
                for (int i = 0; i < 20; i++) {
                    System.out.println("extendsThread内部类");
                }
            }
        }.start();



        /*
         * 主线程任务
         * */
        for (int i = 0; i < 20; i++) {
            System.out.println("main方法线程");
        }

    }
}
