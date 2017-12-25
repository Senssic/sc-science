package com.sc.science.designmode.uniformity.composite;

/**
 * 容器角色,使Leaf角色和Composite角色具有一致性角色
 *
 * @author qiss
 */
public abstract class Entry {
    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    public void printList() {                                       // 为一览加上前缀并显示目录条目一览
        printList("");
    }

    protected abstract void printList(String prefix);

    @Override
    public String toString() {                                      // 显示代表类的文字
        return getName() + " (" + getSize() + ")";
    }
}
