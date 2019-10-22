package com.wmm.designmode.command.composite_command_mixed_mode;

/**
 * @author wangmingming160328
 * @Description 解压命令
 * @date @2019/10/9 11:14
 */
public class CompressCommand implements Command {
    private Receiver receiver;

    public CompressCommand() {
        this.receiver = new ReceiverB();
    }

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        receiver.action();
    }
}
