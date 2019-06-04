package com.wmm.designmode.strategymode;

import com.wmm.designmode.strategymode.strategy.Strategy;

public class StrategyContext {
    private Strategy strategy;

    public StrategyContext(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod () {
        strategy.delete();
    }
}
