package com.wmm.concurrent.threadpool;

import java.util.concurrent.*;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/21 14:30
 */
public class SinglePoolDemo {
    private static Callable<Integer> getThread(final int i){
        return new Callable<Integer>() {
            @Override
            public Integer call() {
                try {

                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
                return i;
            }
        };
    }

    public static void main(String args[]) throws InterruptedException {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(new ThreadGroup("singlePool"), r,"hello");
            }
        };
        ExecutorService singPool = Executors.newSingleThreadExecutor(threadFactory);
        for (int i=0;i<10;i++){
            singPool.submit(getThread(i));
        }
        singPool.shutdown();
    }

/*    private Callable<Object> getTask(final int i) {
        return new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
                return i;
            }
        };
    }

    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(new ThreadGroup("singlePool"), "demo-pool-%d");
            }
        };
        ExecutorService singlePool = Executors.newSingleThreadExecutor(threadFactory);
        for (int i = 0; i < 10; i++) {
            singlePool.submit(new SinglePoolDemo().getTask(i));
        }
        singlePool.shutdown();
    }*/
}
