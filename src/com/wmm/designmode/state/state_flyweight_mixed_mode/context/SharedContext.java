package com.wmm.designmode.state.state_flyweight_mixed_mode.context;

import com.wmm.designmode.state.state_flyweight_mixed_mode.state.State;
import com.wmm.designmode.state.state_flyweight_mixed_mode.state.impl.ConcreteStateA;
import com.wmm.designmode.state.state_flyweight_mixed_mode.state.impl.ConcreteStateB;

import java.util.HashMap;

/**
 * 环境角色：也称为上下文，它定义了客户感兴趣的接口，维护一个当前状态，并将与状态相关的操作委托给当前状态对象来处理
 *
 * @author wangmingming160328
 * @Description
 * @date @2019/10/9 15:26
 */
public class SharedContext {
    private State state;

    /**
     * 共享状态Map
     */
    private HashMap<String, State> stateHashMap = new HashMap<>();

    public SharedContext() {
        this.state = new ConcreteStateA();
        stateHashMap.put("1", state);
        this.state = new ConcreteStateB();
        stateHashMap.put("2", state);

        state = getState("1");
    }

    public State getState(String key) {
        return this.stateHashMap.get(key);
    }

    public void setState(State state) {
        this.state = state;
    }

    /**
     * 对请求做处理
     */
    public void handle() {
        state.handle(this);
    }
}
