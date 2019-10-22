package com.wmm.concurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/21 15:05
 */
public class CachePool {
    private static Runnable getThread(final int i){
        return new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                }catch (Exception e){

                }
                System.out.println(i);
            }
        };
    }

    public static  void main(String[] args){
        ExecutorService cachePool = Executors.newCachedThreadPool();
        for (int i=1;i<=100;i++){
            cachePool.execute(getThread(i));
        }
    }
}
