package com.sc.science.designmode.visitdatastructure.visitor;

/**
 * 元素,接受访问者的accept方法.accept方法接收到的参数是visitor角色
 * @author qiss
 */
public interface Element {
    public abstract void accept(Visitor v);
}
