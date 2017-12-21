package com.sc.science.designmode.toinstance.AbstractFactory.tablefactory;


import com.sc.science.designmode.toinstance.AbstractFactory.factory.Factory;
import com.sc.science.designmode.toinstance.AbstractFactory.factory.Link;
import com.sc.science.designmode.toinstance.AbstractFactory.factory.Page;
import com.sc.science.designmode.toinstance.AbstractFactory.factory.Tray;

public class TableFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new TableLink(caption, url);
    }
    public Tray createTray(String caption) {
        return new TableTray(caption);
    }
    public Page createPage(String title, String author) {
        return new TablePage(title, author);
    }
}
