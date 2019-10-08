package com.wmm.concurrent.threadpool;

import java.util.concurrent.*;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/8/12 15:11
 */
public class FutureTaskDemo {
    public static void main(String[] args) {
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(new ThreadGroup("TEST"), r, "FutureTaskDemo");
            }
        };
        //第一种方式:Future + ExecutorService
        Task task0 = new Task();
        ExecutorService executorService = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        Future<Integer> future0 = executorService.submit(task0);
        executorService.shutdown();

        //第二种方式: FutureTask + ExecutorService
        Task task1 = new Task();
        FutureTask<Integer> futureTask = new FutureTask<>(task1);
        executorService.submit(futureTask);
        executorService.shutdown();
    }

    public static class Task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            System.out.println("Thread [" + Thread.currentThread().getName() + "] is running");
            int result = 0;
            for(int i = 0; i < 100;++i) {
                result += i;
            }

            Thread.sleep(3000);
            return result;
        }
    }
}
