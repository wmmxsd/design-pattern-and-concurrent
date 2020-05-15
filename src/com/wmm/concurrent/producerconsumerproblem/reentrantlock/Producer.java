package com.wmm.concurrent.producerconsumerproblem.reentrantlock;

/**
 * @author wangmingming160328
 * @Description 生产者
 * @date @2020/5/15 12:38
 */
public class Producer extends Lock implements com.wmm.concurrent.producerconsumerproblem.Producer {
    private static final int FULL = 10;

    @Override
    public void produce() {
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        try {
            LOCK.lock();
            while (count == FULL) {
                try {
                    NOT_FULL.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            System.out.println("【生产者" + Thread.currentThread().getName()
                    + "】生产一个产品，现库存" + count);
            NOT_EMPTY.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LOCK.unlock();
        }
    }
}
