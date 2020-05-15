package com.wmm.concurrent.producerconsumerproblem.waitAndNotify;

/**
 * @author wangmingming160328
 * @Description 消费者
 * @date @2020/5/15 11:10
 */
public class Consumer extends Lock implements com.wmm.concurrent.producerconsumerproblem.Consumer {
    @Override
    public void consume() {
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (Lock.class) {
            while (count == 0) {
                try {
                    Lock.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count--;
            System.out.println(Thread.currentThread().getName() + "：消费者消费，目前总共有" + count + "个产品");
            Lock.class.notifyAll();
        }
    }
}
