package com.wmm.designmode.observer_pattern.subject0;

import com.wmm.designmode.observer_pattern.observer0.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmingming160328
 * @Description 抽象目标
 * @date @2019/9/19 10:58
 */
public abstract class AbstractSubject {
    /**
     * 队列
     */
    List<Observer> observers = new ArrayList<>();

    /**
     * 增加观察者方法
     *
     * @param observer 观察者
     */
    public void add(Observer observer) {
        observers.add(observer);
    }

    /**
     * 删除观察者方法
     *
     * @param observer 观察者
     */
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    /**
     * 通知观察者方法
     */
    public abstract void notifyObserver();
}
