package com.wmm.designmode.command;

/**
 * 接收者
 *
 * @author wangmingming160328
 * @Description
 * @date @2019/10/9 11:11
 */
public class ReceiverA implements Receiver{
    /**
     * 执行
     */
    @Override
    public void action() {
        System.out.println("【ReceiverA——action()方法被调用】");
    }
}
