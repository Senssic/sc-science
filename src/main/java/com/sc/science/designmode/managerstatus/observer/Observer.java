package com.sc.science.designmode.managerstatus.observer;

/**
 * 抽象观察者
 * @author qiss
 */
public interface Observer {
    /**
     * 获取到最新状态
     * @param generator
     */
    public abstract void update(NumberGenerator generator);
}
