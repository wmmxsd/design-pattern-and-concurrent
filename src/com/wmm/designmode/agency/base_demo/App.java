package com.wmm.designmode.agency.base_demo;

import com.wmm.designmode.agency.base_demo.agency.Agency;
import com.wmm.designmode.agency.base_demo.agency.LianJiaAgency;
import com.wmm.designmode.agency.base_demo.colleague.Colleague;
import com.wmm.designmode.agency.base_demo.colleague.OtherColleague;
import com.wmm.designmode.agency.base_demo.colleague.VrvColleague;

/**
 * @author wangmingming160328
 * @Description 主程序入口
 * @date @2019/10/9 18:11
 */
class App {
    public static void main(String[] args) {
        Agency agency = new LianJiaAgency();
        Colleague colleague0 = new VrvColleague();
        Colleague colleague1 = new OtherColleague();
        agency.register(colleague0);
        agency.register(colleague1);

        colleague0.send();
    }
}
