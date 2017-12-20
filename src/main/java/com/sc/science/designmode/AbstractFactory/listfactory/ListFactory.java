package com.sc.science.designmode.AbstractFactory.listfactory;


import com.sc.science.designmode.AbstractFactory.factory.Factory;
import com.sc.science.designmode.AbstractFactory.factory.Link;
import com.sc.science.designmode.AbstractFactory.factory.Page;
import com.sc.science.designmode.AbstractFactory.factory.Tray;

public class ListFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
