package com.wmm.designmode.composite_mode.component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmingming160328
 * @Description 树枝构件
 * @date @2019/10/8 18:12
 */
public class Composite extends BaseComponent {
    private List<BaseComponent> children;

    public Composite(String name) {
        super(name);
        this.children = new ArrayList<>();
    }

    public void add(BaseComponent baseComponent) {
        this.children.add(baseComponent);
    }

    public void remove(BaseComponent baseComponent) {
        this.children.remove(baseComponent);
    }

    public BaseComponent getChild(int i) {
        return this.children.get(i);
    }

    /**
     * 操作
     *
     * @return name
     */
    @Override
    public String operation() {
        StringBuilder builder = new StringBuilder(this.name);
        for (BaseComponent component : this.children) {
            builder.append("\n");
            builder.append(component.operation());
        }
        return builder.toString();
    }
}
