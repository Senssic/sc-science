package com.sc.science.designmode.toinstance.singleton;

/**
 * 单例模式
 *
 * @author qiss
 */
public class Singleton {
    /**
     * 饱汉模式
     */
    private static Singleton singleton = new Singleton();

    private Singleton() {
        System.out.println("生成了一个实例。");
    }

    public static Singleton getInstance() {
        return singleton;
    }

}
