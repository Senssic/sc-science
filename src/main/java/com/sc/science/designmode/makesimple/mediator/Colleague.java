package com.sc.science.designmode.makesimple.mediator;

/**
 * 抽象同事类
 *
 * @author qiss
 */
public abstract class Colleague {

    private Mediator mediator;

    /**
     * 构造函数
     */
    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    /**
     * 获取当前同事类对应的调停者对象
     */
    public Mediator getMediator() {
        return mediator;
    }
}