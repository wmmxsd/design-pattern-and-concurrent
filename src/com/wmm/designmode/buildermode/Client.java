package com.wmm.designmode.buildermode;

import com.wmm.designmode.buildermode.builder.AbstractBuilder;
import com.wmm.designmode.buildermode.builder.ConcreteBuilder;
import com.wmm.designmode.buildermode.builder.Director;
import com.wmm.designmode.buildermode.product.Product;

/**
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 15:27
 */
public class Client {
    public static void main(String[] args) {
        AbstractBuilder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.build();
        product.show();
    }
}
