package com.wmm.designmode.command.composite_command_mixed_mode;

/**
 * 接收者
 *
 * @author wangmingming160328
 * @Description
 * @date @2019/10/9 11:11
 */
public class ReceiverB implements Receiver {
    /**
     * 执行
     */
    @Override
    public void action() {
        System.out.println("【ReceiverB——action()方法被调用】");
    }
}
