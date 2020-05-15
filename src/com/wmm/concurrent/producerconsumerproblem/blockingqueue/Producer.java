package com.wmm.concurrent.producerconsumerproblem.blockingqueue;

/**
 * @author wangmingming160328
 * @Description 生产者
 * @date @2020/5/15 11:48
 */
public class Producer extends Quene implements com.wmm.concurrent.producerconsumerproblem.Producer {
    @Override
    public void produce() {
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        QUENE.add(new Object());
        System.out.println("【生产者" + Thread.currentThread().getName()
                + "】生产一个产品，现库存" + QUENE.size());
    }
}
