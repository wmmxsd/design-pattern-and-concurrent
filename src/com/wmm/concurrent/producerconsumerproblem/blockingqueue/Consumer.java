package com.wmm.concurrent.producerconsumerproblem.blockingqueue;

/**
 * @author wangmingming160328
 * @Description 消费者
 * @date @2020/5/15 11:49
 */
public class Consumer extends Quene implements com.wmm.concurrent.producerconsumerproblem.Consumer {
    @Override
    public void consume() {
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        QUENE.remove();
        System.out.println("【消费者" + Thread.currentThread().getName()
                + "】消费了一个产品，现库存" + QUENE.size());
    }
}
