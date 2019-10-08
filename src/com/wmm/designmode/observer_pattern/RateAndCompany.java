package com.wmm.designmode.observer_pattern;

import com.wmm.designmode.observer_pattern.observer1.ExportCompany;
import com.wmm.designmode.observer_pattern.observer1.ImportCompany;
import com.wmm.designmode.observer_pattern.subject1.AbstractRate;
import com.wmm.designmode.observer_pattern.subject1.RMBRate;

/**
 * @author wangmingming160328
 * @Description 进出口公司与汇率主程序入口
 * @date @2019/9/19 11:25
 */
public class RateAndCompany {
    public static void main(String[] args) {
        AbstractRate rate = new RMBRate();

        ImportCompany importCompany = new ImportCompany();
        ExportCompany exportCompany = new ExportCompany();

        rate.add(importCompany);
        rate.add(exportCompany);

        rate.changeRate(1);
        rate.changeRate(-1);

        rate.remove(exportCompany);
        rate.changeRate(22);
    }
}
