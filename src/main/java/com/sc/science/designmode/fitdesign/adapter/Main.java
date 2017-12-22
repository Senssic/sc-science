package com.sc.science.designmode.fitdesign.adapter;

public class Main {
    public static void main(String[] args) {

        Print p = new PrintBanner("Hello");
        p.printWeak();//banner中的showWithParen被适配成了printWeak
        p.printStrong();//banner中的showWithAster被适配成了printStrong
    }
}
