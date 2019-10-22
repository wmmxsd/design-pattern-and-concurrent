package com.wmm.designmode.command.composite_command_mixed_mode;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/9 13:46
 */
public class App {
    public static void main(String[] args) {
        CompositeInvokerComponent invokerComponent = new CompositeInvokerComponent();
        Command unzip = new UnzipCommand();
        Command compress = new CompressCommand();
        invokerComponent.add(unzip);
        invokerComponent.add(compress);
        invokerComponent.execute();

        CompositeInvokerComponent invokerComponent1 = new CompositeInvokerComponent();


        invokerComponent.add(invokerComponent1);
        invokerComponent.execute();
    }
}
