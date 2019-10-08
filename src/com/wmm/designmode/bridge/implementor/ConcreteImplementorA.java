package com.wmm.designmode.bridge.implementor;

/**
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
