package com.wmm.designmode.bridge;

import com.wmm.designmode.bridge.abstraction.ConcreteAbstraction;
import com.wmm.designmode.bridge.implementor.ConcreteImplementorA;
import com.wmm.designmode.bridge.implementor.Implementor;

/**
 * 桥接（Bridge）模式的定义如下：将抽象与实现分离，使它们可以独立变化。它是用组合关系代替继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度
 *
 * @author wangmingming160328
 * @Description
 * @date @2019/10/8 14:02
 */
public class App {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementorA();
        ConcreteAbstraction concreteAbstraction = new ConcreteAbstraction(implementor);
        concreteAbstraction.operation();
    }
}
