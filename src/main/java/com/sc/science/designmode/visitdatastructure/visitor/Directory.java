package com.sc.science.designmode.visitdatastructure.visitor;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 文件夹数据
 *
 * @author qiss
 */
public class Directory extends Entry {
    private String name;
    private ArrayList dir = new ArrayList();

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
        Iterator it = dir.iterator();
        while (it.hasNext()) {
            Entry entry = (Entry) it.next();
            size += entry.getSize();
        }
        return size;
    }

    @Override
    public Entry add(Entry entry) {
        dir.add(entry);
        return this;
    }

    @Override
    public Iterator iterator() {      // 生成Iterator
        return dir.iterator();
    }

    @Override
    public void accept(Visitor v) {         // 接受访问者的访问
        v.visit(this);
    }
}
