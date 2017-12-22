package com.sc.science.designmode.toinstance.abstractfactory.tablefactory;


import com.sc.science.designmode.toinstance.abstractfactory.factory.Link;

public class TableLink extends Link {
    public TableLink(String caption, String url) {
        super(caption, url);
    }
    public String makeHTML() {
        return "<td><a href=\"" + url + "\">" + caption + "</a></td>\n";
    }
}
