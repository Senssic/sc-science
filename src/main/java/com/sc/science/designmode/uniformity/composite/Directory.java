package com.sc.science.designmode.uniformity.composite;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 复合物角色,可以在其中放入Leaf角色和Composite角色
 *
 * @author qiss
 */
public class Directory extends Entry {
    private String name;
    private ArrayList directory = new ArrayList();

    public Directory(String name) {         // 构造函数
        this.name = name;
    }

    @Override
    public String getName() {               // 获取名字
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            size += entry.getSize();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry) {
        directory.add(entry);
        return this;
    }

    @Override
    protected void printList(String prefix) {
        System.out.println(prefix + "/" + this);
        Iterator it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            entry.printList(prefix + "/" + name);
        }
    }
}
