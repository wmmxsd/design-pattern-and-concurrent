package com.wmm.designmode.command;

/**
 * 命令模式（）
 *
 * @author wangmingming160328
 * @Description 程序入口
 * @date @2019/10/9 11:15
 */
public class App {
    public static void main(String[] args) {
        Command command = new UnzipCommand();
        Invoker invoker = new Invoker(command);
        invoker.call();
    }
}
