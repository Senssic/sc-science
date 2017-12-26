package com.sc.science.designmode.managerstatus.memento.game;

import java.util.ArrayList;
import java.util.List;

/**
 * 发起人角色
 *
 * @author qiss
 */
public class Memento {
    int money;                              // 所持金钱
    ArrayList fruits;                       // 当前获得的水果

    Memento(int money) {                    // 构造函数(wide interface)
        this.money = money;
        this.fruits = new ArrayList();
    }

    public int getMoney() {                 // 获取当前所持金钱（narrow interface）
        return money;
    }

    void addFruit(String fruit) {           // 添加水果(wide interface)
        fruits.add(fruit);
    }

    List getFruits() {                      // 获取当前所持所有水果（wide interface）
        return (List) fruits.clone();
    }
}
