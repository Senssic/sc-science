package com.sc.science.designmode.toinstance.abstractfactory.listfactory;


import com.sc.science.designmode.toinstance.abstractfactory.factory.Factory;
import com.sc.science.designmode.toinstance.abstractfactory.factory.Link;
import com.sc.science.designmode.toinstance.abstractfactory.factory.Page;
import com.sc.science.designmode.toinstance.abstractfactory.factory.Tray;

/**
 * 具体工厂类继承factory
 *
 * @author qiss
 */
public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }

    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
