package cn.Rubter.cn.ThreadDemo.tongBu;

public class lambdaDemo {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类——》面向对象编程");
            }
        }).start();

        /*lambda思想编程*/
        new Thread(() -> {
            System.out.println("lambda思想编程");
        }).start();
    }
}
