package com.wmm.designmode.bridge.abstraction;

import com.wmm.designmode.bridge.implementor.Implementor;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/8 14:01
 */
public class ConcreteAbstraction extends Abstraction{
    public ConcreteAbstraction(Implementor implementor) {
        super(implementor);
    }

    /**
     * 操作
     */
    @Override
    public void operation() {
        implementor.operation();
    }
}
