package com.sc.science.designmode.separate.strategy;

/**
 * 策略,算法接口
 * @author qiss
 */
public interface Strategy {
    /**
     * 具体算法
     * @return
     */
    public abstract Hand nextHand();

    /**
     * 具体算法
     * @param win
     */
    public abstract void study(boolean win);
}
