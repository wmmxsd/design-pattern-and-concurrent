package com.wmm.designmode.agency.base_demo.agency;

import com.wmm.designmode.agency.base_demo.colleague.Colleague;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmingming160328
 * @Description 链家中介
 * @date @2019/10/10 9:57
 */
public class LianJiaAgency implements Agency {
    private List<Colleague> colleagueList = new ArrayList<>();


    /**
     * 同时对象注册方法
     *
     * @param colleague 同事对象
     */
    @Override
    public void register(Colleague colleague) {
        if (colleagueList.contains(colleague)) {
            System.out.println("该同事已注册");
            return;
        }
        colleagueList.add(colleague);
        colleague.setAgency(this);
        System.out.println("注册成功");
    }

    /**
     * 转发消息
     *
     * @param colleague 同事
     */
    @Override
    public void relay(Colleague colleague) {
        for (Colleague tempColleague : colleagueList) {
            if (!tempColleague.equals(colleague)) {
                tempColleague.receive();
            }
        }
    }
}
