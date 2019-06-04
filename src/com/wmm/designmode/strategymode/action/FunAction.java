package com.wmm.designmode.strategymode.action;

import com.wmm.designmode.strategymode.StrategyContext;
import com.wmm.designmode.strategymode.strategy.Strategy;
import com.wmm.designmode.strategymode.strategy.strategyImpl.USBStrategy;

public class FunAction {
    public static void main(String[] args) {
        Strategy strategy = new USBStrategy();
        StrategyContext strategyContext = new StrategyContext(strategy);
        strategyContext.strategyMethod();
    }
}
