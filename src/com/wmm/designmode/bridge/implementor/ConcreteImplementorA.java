package com.wmm.designmode.bridge.implementor;

/**
 * 具体实现化（Concrete Implementor）角色：给出实现化角色接口的具体实现
 *
 * @author wangmingming160328
 * @Description
 * @date @2019/10/8 13:58
 */
public class ConcreteImplementorA implements Implementor{
    /**
     * 操作
     */
    @Override
    public void operation() {
        System.out.println("操作成功");
    }
}
