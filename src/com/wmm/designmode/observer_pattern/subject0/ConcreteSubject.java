package com.wmm.designmode.observer_pattern.subject0;

import com.wmm.designmode.observer_pattern.observer0.Observer;

/**
 * @author wangmingming160328
 * @Description 具体目标
 * @date @2019/9/19 11:01
 */
public class ConcreteSubject extends AbstractSubject {
    /**
     * 通知观察者方法
     */
    @Override
    public void notifyObserver() {
        System.out.println("具体目标发生改变...");
        System.out.println("--------------");

        for (Object obs : observers) {
            ((Observer) obs).response();
        }
    }
}
