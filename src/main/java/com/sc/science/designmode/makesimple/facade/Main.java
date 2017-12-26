package com.sc.science.designmode.makesimple.facade;


import com.sc.science.designmode.makesimple.facade.pagemaker.PageMaker;

/**
 * 使用者只要调用一个方法就行了
 */
public class Main {
    public static void main(String[] args) {
        PageMaker.makeWelcomePage("hyuki@hyuki.com", "welcome.html");
    }
}
