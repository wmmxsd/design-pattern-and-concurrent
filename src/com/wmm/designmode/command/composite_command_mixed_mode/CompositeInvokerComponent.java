package com.wmm.designmode.command.composite_command_mixed_mode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmingming160328
 * @Description 调用者
 * @date @2019/10/9 11:49
 */
public class CompositeInvokerComponent implements Command {
    private List<Command> commandList;

    public CompositeInvokerComponent() {
        this.commandList = new ArrayList<>();
    }

    public void add(Command baseComponent) {
        this.commandList.add(baseComponent);
    }

    public void remove(Command baseComponent) {
        this.commandList.remove(baseComponent);
    }

    public Command getChild(int i) {
        return this.commandList.get(i);
    }

    /**
     * 执行命令
     */
    @Override
    public void execute() {
        for (Command command : commandList) {
            command.execute();
        }
    }
}
