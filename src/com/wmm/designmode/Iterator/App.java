package com.wmm.designmode.Iterator;

import com.wmm.designmode.Iterator.aggregation.ConcreteAggreation;
import com.wmm.designmode.Iterator.iterator.Iterator;

/**
 * @author wangmingming160328
 * @Description 主程序入口
 * @date @2019/10/11 9:35
 */
public class App {
    public static void main(String[] args) {
        ConcreteAggreation<Integer> aggreation = new ConcreteAggreation<>();
        aggreation.add(0);
        aggreation.add(1);
        aggreation.add(2);
        aggreation.add(3);
        aggreation.add(4);
        aggreation.add(5);
        aggreation.add(6);
        aggreation.remove(6);
        Iterator iterator = aggreation.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
