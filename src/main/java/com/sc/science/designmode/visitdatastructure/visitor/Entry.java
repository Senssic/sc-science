package com.sc.science.designmode.visitdatastructure.visitor;

import java.util.Iterator;

/**
 * 数据抽象类,统一File和Directory
 *
 * @author qiss
 */
public abstract class Entry implements Element {
    public abstract String getName();

    public abstract int getSize();

    public Entry add(Entry entry) throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    public Iterator iterator() throws FileTreatmentException {
        throw new FileTreatmentException();
    }

    @Override
    public String toString() {                                          // 显示字符串
        return getName() + " (" + getSize() + ")";
    }
}
