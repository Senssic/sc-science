package com.sc.science.designmode.separate.strategy;

public interface Strategy {
    public abstract Hand nextHand();
    public abstract void study(boolean win);
}
