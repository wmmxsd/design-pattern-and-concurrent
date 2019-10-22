package com.wmm.designmode.composite_mode.component;

/**
 * 组件
 * @author wmm
 */
public abstract class BaseComponent {
    protected String name;

    BaseComponent(String name) {
        this.name = name;
    }

    /**
     * 操作
     * @return name
     */
    public abstract String operation();
}
