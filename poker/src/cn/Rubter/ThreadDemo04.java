package cn.Rubter;

import java.time.chrono.MinguoChronology;

/**
 * 模拟秒针：
 * 使用sleep方法
 */

public class ThreadDemo04 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        for (int hour = 1; hour <= 24; hour++) {
            for (int min = 1; min <= 60; min++) {
                System.out.println(hour + ":" + min + " ");//输出时加分，60秒执行一次输出
                for (int i = 1; i <= 60; i++) {
                    Thread.sleep(1000);
                }
            }
        }

    }
}
