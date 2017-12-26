package com.sc.science.designmode.managerstatus.observer;

/**
 * 具体观察者1
 *
 * @author qiss
 */
public class DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver:" + generator.getNumber());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
