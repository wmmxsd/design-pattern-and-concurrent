package com.wmm.concurrent.producerconsumerproblem.waitAndNotify;

/**
 * @author wangmingming160328
 * @Description 生产者
 * @date @2020/5/15 11:01
 */
public class Producer extends Lock implements com.wmm.concurrent.producerconsumerproblem.Producer {
    private int maxSize = 10;

    @Override
    public void produce() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (Lock.class) {
            while (count == maxSize) {
                try {
                    Lock.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "：生产者生产，目前总共有" + count + "个产品");
            Lock.class.notifyAll();
        }
    }
}
