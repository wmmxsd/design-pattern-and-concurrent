package com.wmm.designmode.observer_pattern.subject1;

import com.wmm.designmode.observer_pattern.observer1.Company;

/**
 * @author wangmingming160328
 * @Description 人名币汇率
 * @date @2019/9/19 11:19
 */
public class RMBRate extends AbstractRate{
    /**
     * 通知公司方法
     * @param num 汇率变化值
     */
    @Override
    public void changeRate(int num) {
        for (Company company : companyList){
            company.response(num);
        }
    }
}
