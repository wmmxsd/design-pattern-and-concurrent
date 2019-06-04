package com.wmm.designmode.strategymode.strategy.strategyImpl;

import com.wmm.designmode.strategymode.strategy.strategy;

public class SoftStrategy implements strategy {
    @Override
    public void delete() {
        System.out.println("softStrategy delete");
    }
}
