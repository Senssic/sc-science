package com.sc.science.designmode.toinstance.builder;

/**
 * 建造者抽象类
 * @author qiss
 */
public abstract class Builder {
    /**
     *建造组块标题
     * @param title
     */
    public abstract void makeTitle(String title);

    /**
     * 建造组块内容
     * @param str
     */
    public abstract void makeString(String str);

    /**
     * 建造组块目录
     * @param items
     */
    public abstract void makeItems(String[] items);

    /**
     * 关闭建造
     */
    public abstract void close();
}
