package com.wmm.designmode.bridge.abstraction;

import com.wmm.designmode.bridge.implementor.Implementor;

/**
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
