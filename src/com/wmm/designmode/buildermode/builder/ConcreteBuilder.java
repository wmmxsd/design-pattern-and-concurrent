package com.wmm.designmode.buildermode.builder;

/**
 * 具体建设者
 *
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 15:20
 */
public class ConcreteBuilder extends AbstractBuilder<ConcreteBuilder>{
    @Override
    public void buildPartA() {
        product.setPartA("建设partA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("建设partB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("建设partC");
    }
}
