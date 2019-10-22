package com.wmm.designmode.state.state_flyweight_mixed_mode.state.impl;

import com.wmm.designmode.state.state_flyweight_mixed_mode.context.SharedContext;
import com.wmm.designmode.state.state_flyweight_mixed_mode.state.State;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/9 15:30
 */
public class ConcreteStateB implements State {
    /**
     * 处理
     *
     * @param context 环境
     */
    @Override
    public void handle(SharedContext context) {
        System.out.println("当前状态是 B.");
        context.setState(context.getState("1"));
    }
}
