package com.wmm.designmode.observer_pattern.observer1;

/**
 * @author wangmingming160328
 * @Description 进口公
 * @date @2019/9/19 11:22
 */
public class ImportCompany implements Company {
    /**
     * 通知
     *
     * @param num 汇率变化值
     */
    @Override
    public void response(int num) {
        if (num > 0) {
            System.out.println("人民币汇率升值" + num + "个基点，降低了进口产品成本，提升了进口公司利润率。");
        } else if (num < 0) {
            System.out.println("人民币汇率贬值" + (-num) + "个基点，提升了进口产品成本，降低了进口公司利润率。");
        }
    }
}
