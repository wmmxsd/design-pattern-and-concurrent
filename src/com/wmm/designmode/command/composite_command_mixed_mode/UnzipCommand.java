package com.wmm.designmode.command.composite_command_mixed_mode;

import com.wmm.designmode.command.Receiver;
import com.wmm.designmode.command.ReceiverA;

/**
 * @author wangmingming160328
 * @Description 解压命令
 * @date @2019/10/9 11:14
 */
public class UnzipCommand implements Command {
    private Receiver receiver;

    public UnzipCommand() {
        this.receiver = new ReceiverA();
    }

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        receiver.action();
    }
}
