package com.sc.science.designmode.separate.bridge;

/**
 * 抽象化,类的功能层次结构最上层
 *
 * @author qiss
 */
public class Display {
    /**
     * 实现者,类层次结构的最上层
     */
    private DisplayImpl impl;

    public Display(DisplayImpl impl) {
        this.impl = impl;
    }

    public void open() {
        impl.rawOpen();
    }

    public void print() {
        impl.rawPrint();
    }

    public void close() {
        impl.rawClose();
    }

    public final void display() {
        open();
        print();
        close();
    }
}
