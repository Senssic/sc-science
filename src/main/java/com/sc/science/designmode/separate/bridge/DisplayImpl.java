package com.sc.science.designmode.separate.bridge;

/**
 *  实现者,类层次结构的最上层
 *  @author qiss
 */
public abstract class DisplayImpl {
    /**
     * 定义类功能方法
     */
    public abstract void rawOpen();

    /**
     * 定义类功能方法
     */
    public abstract void rawPrint();

    /**
     * 定义类功能方法
     */
    public abstract void rawClose();
}
