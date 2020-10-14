package cn.Rubter.cn.ThreadDemo.tongBu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池使用
 * Executor执行者
 * concurrent并存的;同时发生的
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new PoolThread("线程池测试"));
        // executorService.shutdown();//销毁线程，不建议执行

    }
}
