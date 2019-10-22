package com.wmm.concurrent.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/21 15:11
 */
public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        ses.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(4000);
                    System.out.println(Thread.currentThread().getId() + "执行了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 1, TimeUnit.MINUTES);
    }

}
