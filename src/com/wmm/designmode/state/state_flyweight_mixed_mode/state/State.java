package com.wmm.designmode.state.state_flyweight_mixed_mode.state;

import com.wmm.designmode.state.state_flyweight_mixed_mode.context.SharedContext;

/**
 *抽象状态角色：定义一个接口，用以封装环境对象中的特定状态所对应的行为
 *
 * @author wmm
 */
public interface State {
    /**
     * 处理
     * @param context 环境
     */
    void handle(SharedContext context);
}
