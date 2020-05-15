package com.wmm.concurrent.producerconsumerproblem.semaphore;

/**
 * @author wangmingming160328
 * @Description 生产者
 * @date @2020/5/15 10:05
 */
public class Producer extends Semaphore implements com.wmm.concurrent.producerconsumerproblem.Producer {
    @Override
    public void produce(){
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                NOT_FULL.acquire();
                MUTEX.acquire();
                count++;
                System.out.println(Thread.currentThread().getName()
                        + "生产者生产，目前总共有" + count);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                MUTEX.release();
                NOT_EMPTY.release();
            }
        }

    }
}
