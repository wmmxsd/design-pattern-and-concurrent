package com.wmm.designmode.observer_pattern.observer0;

/**
 * @author wangmingming160328
 * @Description 具体观察者1
 * @date @2019/9/19 11:03
 */
public class ConcreteObserver1 implements Observer{
    /**
     * 反应
     */
    @Override
    public void response() {
        System.out.println("具体观察者1作出反应！");
    }
}
