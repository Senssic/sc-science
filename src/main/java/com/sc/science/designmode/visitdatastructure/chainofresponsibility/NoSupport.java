package com.sc.science.designmode.visitdatastructure.chainofresponsibility;

/**
 * 职责链三
 *
 * @author qiss
 */
public class NoSupport extends Support {
    public NoSupport(String name) {
        super(name);
    }

    @Override
    protected boolean resolve(Trouble trouble) {     // 解决问题的方法
        return false; // 自己什么也不处理
    }
}
