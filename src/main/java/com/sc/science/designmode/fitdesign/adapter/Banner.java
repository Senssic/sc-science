package com.sc.science.designmode.fitdesign.adapter;

/**
 * target目标类,需要被转换的不能直接使用的类
 * @author qiss
 */
public class Banner {
    private String string;

    public Banner(String string) {
        this.string = string;
    }

    public void showWithParen() {
        System.out.println("(" + string + ")");
    }

    public void showWithAster() {
        System.out.println("*" + string + "*");
    }
}
