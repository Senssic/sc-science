package com.sc.science.designmode.toinstance.abstractfactory.factory;

/**
 * 抽象产品Item
 *
 * @author qiss
 */
public abstract class Item {
    protected String caption;

    public Item(String caption) {
        this.caption = caption;
    }

    /**
     * 抽象产品的抽象制作方法
     * @return
     */
    public abstract String makeHTML();
}
