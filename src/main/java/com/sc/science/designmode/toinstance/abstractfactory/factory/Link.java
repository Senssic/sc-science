package com.sc.science.designmode.toinstance.abstractfactory.factory;

/**
 * 抽象产品Link继承抽象产品Item
 * @author qiss
 */
public abstract class Link extends Item {
    protected String url;
    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
