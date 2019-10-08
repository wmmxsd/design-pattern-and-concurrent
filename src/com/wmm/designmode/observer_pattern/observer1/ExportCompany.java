package com.wmm.designmode.observer_pattern.observer1;

/**
 * @author wangmingming160328
 * @Description 出口公司
 * @date @2019/9/19 11:23
 */
public class ExportCompany implements Company {
    /**
     * 通知
     *
     * @param num 汇率变化值
     */
    @Override
    public void response(int num) {
        if (num > 0) {
            System.out.println("人民币汇率升值" + num + "个基点，降低了出口产品收入，降低了出口公司的销售利润率。");
        } else if (num < 0) {
            System.out.println("人民币汇率贬值" + (-num) + "个基点，提升了出口产品收入，提升了出口公司的销售利润率。");
        }
    }
}
