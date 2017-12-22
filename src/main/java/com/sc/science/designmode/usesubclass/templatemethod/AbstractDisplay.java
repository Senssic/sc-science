package com.sc.science.designmode.usesubclass.templatemethod;

/**
 * 抽象类
 * @author qiss
 */
public abstract class AbstractDisplay {
    /**
     * 抽象方法open
     */
    public abstract void open();

    /**
     * 抽象方法print
     */
    public abstract void print();

    /**
     * 抽象方法close
     */
    public abstract void close();

    public final void display() {//模版方法,模版方法可以使用各个实例化好的子类做不同事情
        open();
        for (int i = 0; i < 5; i++) {
            print();
        }
        close();
    }
}
