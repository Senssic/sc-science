package com.sc.science.designmode.toinstance.abstractfactory.tablefactory;


import com.sc.science.designmode.toinstance.abstractfactory.factory.Factory;
import com.sc.science.designmode.toinstance.abstractfactory.factory.Link;
import com.sc.science.designmode.toinstance.abstractfactory.factory.Page;
import com.sc.science.designmode.toinstance.abstractfactory.factory.Tray;

/**
 * 具体工厂TableFactory
 *
 * @author qiss
 */
public class TableFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
