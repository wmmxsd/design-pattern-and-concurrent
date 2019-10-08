package com.wmm.designmode.buildermode.builder;

import com.wmm.designmode.buildermode.product.Product;

/**
 * 抽象建设者
 *
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 15:19
 */
public abstract class AbstractBuilder<T> {
    Product product = new Product();

    public abstract void buildPartA();
    public abstract void buildPartB();
    public abstract void buildPartC();

    //返回产品对象
    public Product getResult()
    {
        return product;
    }
}
