package com.wmm.designmode.observer_pattern;

import com.wmm.designmode.observer_pattern.observer0.ConcreteObserver1;
import com.wmm.designmode.observer_pattern.observer0.ConcreteObserver2;
import com.wmm.designmode.observer_pattern.observer0.Observer;
import com.wmm.designmode.observer_pattern.subject0.AbstractSubject;
import com.wmm.designmode.observer_pattern.subject0.ConcreteSubject;

/**
 * @author wangmingming160328
 * @Description 主程序入口
 * @date @2019/9/19 11:04
 */
public class ObserverPattern {

    public static void main(String[] args) {
        AbstractSubject subject = new ConcreteSubject();
        Observer obs1 = new ConcreteObserver1();
//        Observer obs2 = new ConcreteObserver2();
        subject.add(obs1);
//        subject.add(obs2);
        subject.notifyObserver();
    }
}
