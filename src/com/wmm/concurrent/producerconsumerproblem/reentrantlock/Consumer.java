package com.wmm.concurrent.producerconsumerproblem.reentrantlock;

/**
 * @author wangmingming160328
 * @Description 消费者
 * @date @2020/5/15 12:42
 */
public class Consumer extends Lock implements com.wmm.concurrent.producerconsumerproblem.Consumer {
    @Override
    public void consume() {
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            LOCK.lock();
            while (count == 0){
                try {
                    NOT_EMPTY.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            System.out.println("【消费者" + Thread.currentThread().getName()
                    + "】消费了一个产品，现库存" + count);
            NOT_FULL.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }
}
