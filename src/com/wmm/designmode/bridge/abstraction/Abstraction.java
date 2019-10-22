package com.wmm.designmode.bridge.abstraction;

import com.wmm.designmode.bridge.implementor.Implementor;

/**
 * 抽象化（Abstraction）角色（定义抽象类，并包含一个对实现化对象的引用）
 *
 * @author wangmingming160328
 * @Description
 * @date @2019/10/8 13:59
 */
abstract class Abstraction {
    Implementor implementor;

    Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    /**
     * 操作
     */
    public abstract void operation();
}
