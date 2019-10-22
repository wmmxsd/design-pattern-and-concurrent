package com.wmm.designmode.composite_mode.component;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/10/8 18:09
 */
public class Leaf extends BaseComponent {


    public Leaf(String name) {
        super(name);
    }

    /**
     * 操作
     *
     * @return name
     */
    @Override
    public String operation() {
        return this.name;
    }
}
