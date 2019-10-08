package com.wmm.designmode.observer_pattern.subject1;

import com.wmm.designmode.observer_pattern.observer1.Company;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmingming160328
 * @Description 汇率
 * @date @2019/9/19 11:14
 */
public abstract class AbstractRate {
    /**
     * 公司队列
     */
    protected List<Company> companyList = new ArrayList<>();

    /**
     * 增加观察者方法
     *
     * @param company 公司
     */
    public void add(Company company) {
        companyList.add(company);
        System.out.println("当前队列总数：" + companyList.size());
        System.out.println("当前队列人员：" + companyList.toString());
    }

    /**
     * 删除观察者方法
     *
     * @param company 公司
     */
    public void remove(Company company) {
        companyList.remove(company);
        System.out.println("当前队列总数：" + companyList.size());
        System.out.println("当前队列人员：" + companyList.toString());
    }

    /**
     * 通知公司方法
     * @param num 汇率变化值
     *
     */
    public abstract void changeRate(int num);
}
