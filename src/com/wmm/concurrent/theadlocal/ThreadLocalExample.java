package com.wmm.concurrent.theadlocal;

/**
 * ThreadLocal是线程私有变量，其他线程修改ThreadLocal类型的变量后，当前变量的值不会改变。
 * @author wangmingming160328
 * @Description 线程池Demo
 * @date @2019/7/18 15:08
 */
public class ThreadLocalExample {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    private static int count = 1;

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            threadLocal.set(2);
            count = 2;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "：threadLocal = " + threadLocal.get() + "; count = " + count);
        }
    }

    public static void main(String[] args) {
        threadLocal.set(3);
        count = 3;
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();

        try {
            thread1.join(); //wait for thread 1 to terminate
            thread2.join(); //wait for thread 2 to terminate
            System.out.println(Thread.currentThread().getName() + "：threadLocal = " + threadLocal.get() + "; count = " + count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
