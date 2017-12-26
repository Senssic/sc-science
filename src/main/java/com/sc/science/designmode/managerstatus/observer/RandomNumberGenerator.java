package com.sc.science.designmode.managerstatus.observer;

import java.util.Random;

/**
 * 具体被观察者
 *
 * @author qiss
 */
public class RandomNumberGenerator extends NumberGenerator {
    private Random random = new Random();
    private int number;

    @Override
    public int getNumber() {                // 获取当前数值
        return number;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 20; i++) {
            number = random.nextInt(50);
            //被观察者数据变动通知所有观察者
            notifyObservers();
        }
    }
}
