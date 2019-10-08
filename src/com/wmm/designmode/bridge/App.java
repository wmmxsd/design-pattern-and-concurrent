package com.wmm.designmode.bridge;

import com.wmm.designmode.bridge.abstraction.ConcreteAbstraction;
import com.wmm.designmode.bridge.implementor.ConcreteImplementorA;
import com.wmm.designmode.bridge.implementor.Implementor;

/**
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
