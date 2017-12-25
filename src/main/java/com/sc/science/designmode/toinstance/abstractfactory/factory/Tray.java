package com.sc.science.designmode.toinstance.abstractfactory.factory;
import java.util.ArrayList;

/**
 * 抽象产品Tray
 * @author qiss
 */
public abstract class Tray extends Item {
    protected ArrayList tray = new ArrayList();
    public Tray(String caption) {
        super(caption);
    }
    public void add(Item item) {
        tray.add(item);
    }
}
