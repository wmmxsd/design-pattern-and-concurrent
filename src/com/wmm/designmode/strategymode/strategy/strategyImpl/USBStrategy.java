package com.wmm.designmode.strategymode.strategy.strategyImpl;

import com.wmm.designmode.strategymode.strategy.Strategy;

public class USBStrategy implements Strategy {
    @Override
    public void delete() {
        System.out.println("USBStrategy delete");
    }
}
