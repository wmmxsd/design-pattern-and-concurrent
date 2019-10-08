package com.wmm.concurrent;

/**
 * @author wangmingming160328
 * @Description 竞态条件 & 临界区
 * <B>当两个线程竞争同一资源时，如果对资源的访问顺序敏感，就称存在竞态条件，导致竞态条件发生的代码区称作临界区。</B>
 * <B>在临界区中使用适当的同步就可以避免竞态条件</B>
 * @date @2019/7/17 17:58
 */
public class RaceConditionDemo {
    private static Integer i = 2;

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public synchronized void run() {
                i++;
                System.out.println(i);
            }
        };
        Thread thread0 = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        thread0.start();
        thread1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }

}
