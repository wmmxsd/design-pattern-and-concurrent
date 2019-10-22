package com.wmm.designmode.command;

/**
 * 调用者：是请求的发送者，它通常拥有很多的命令对象，并通过访问命令对象来执行相关请求，它不直接访问接收者
 *
 * @author wangmingming160328
 * @Description 调用者
 * @date @2019/10/9 11:09
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void call() {
        command.execute();
    }
}
