package com.wmm.designmode.buildermode.builder;

import com.wmm.designmode.buildermode.product.Product;

/**
 * 指挥者
 *
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 15:23
 */
public class Director {
    private AbstractBuilder abstractBuilder;

    public Director(AbstractBuilder abstractBuilder) {
        this.abstractBuilder = abstractBuilder;
    }

    public Product build() {
        abstractBuilder.buildPartA();
        abstractBuilder.buildPartB();
        abstractBuilder.buildPartC();
        return abstractBuilder.getResult();
    }
}
