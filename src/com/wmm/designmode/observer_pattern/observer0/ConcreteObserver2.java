package com.wmm.designmode.observer_pattern.observer0;

/**
 * @author wangmingming160328
 * @Description 具体观察者2
 * @date @2019/9/19 11:03
 */
public class ConcreteObserver2 implements Observer{
    /**
     * 反应
     */
    @Override
    public void response() {
        System.out.println("具体观察者2作出反应！");
    }
}
