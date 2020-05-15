package com.wmm.concurrent.producerconsumerproblem.semaphore;

/**
 * @author wangmingming160328
 * @Description 消费者
 * @date @2020/5/15 10:05
 */
public class Consumer extends Semaphore implements com.wmm.concurrent.producerconsumerproblem.Consumer {
    @Override
    public void consume() {
       while (true) {
           try {
               Thread.sleep(2000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           try {
               NOT_EMPTY.acquire();
               MUTEX.acquire();
               count--;
               System.out.println(Thread.currentThread().getName()
                       + "消费者消费，目前总共有" + count);
           } catch (InterruptedException e) {
               e.printStackTrace();
           } finally {
               MUTEX.release();
               NOT_FULL.release();
           }
       }

    }
}
