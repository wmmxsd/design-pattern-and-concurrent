package com.wmm.designmode.bridge.abstraction;

import com.wmm.designmode.bridge.implementor.Implementor;

/**
 * 扩展抽象化（Abstraction）角色（是抽象化角色的子类，实现父类中的业务方法，并通过组合关系调用实现化角色中的业务方法）
 *
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
