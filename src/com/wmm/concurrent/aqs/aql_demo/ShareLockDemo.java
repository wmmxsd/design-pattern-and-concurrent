package com.wmm.concurrent.aqs.aql_demo;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/23 17:10
 */
public class ShareLockDemo {
    private static final Semaphore SEMAPHORE = new Semaphore(20, false);

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(300, 300, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), r -> new Thread(r, String.valueOf(new Random().nextInt(300))));

        final int[] num = {0};
        
        Runnable runnable = () -> {
            try {
                SEMAPHORE.acquire();// 获取一个许可，所以可运行线程数量为20/1=20
                test(++num[0]);
                SEMAPHORE.release();// 释放一个许可
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        };

        int count = 500;
        for (int index = 0; index < count; index++) {
            executorService.execute(runnable);
        }

        executorService.shutdown();

        while (true) {
            if (executorService.isTerminated()) {
                System.out.println("over");
                break;
            }
        }
    }

    private static void test(int i) throws InterruptedException {
        // 模拟请求的耗时操作
        Thread.sleep(500);
        System.out.println("threadnum:" + i);
        // 模拟请求的耗时操作
        Thread.sleep(500);
    }
}
