package com.wmm.designmode.buildermode.product;

/**
 * 产品
 *
 * @author wangmingming160328
 * @Description
 * @date @2019/9/29 15:17
 */
public class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void show() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Product{" + "partA='" + partA + '\'' + ", partB='" + partB + '\'' + ", partC='" + partC + '\'' + '}';
    }
}
