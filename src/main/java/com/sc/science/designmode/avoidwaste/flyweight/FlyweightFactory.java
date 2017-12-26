package com.sc.science.designmode.avoidwaste.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享原对象创建工厂
 *
 * @author qiss
 */
public class FlyweightFactory {
    /**
     * 保存享元对象,类似于线程池
     */
    private Map<Character, Flyweight> files = new HashMap<Character, Flyweight>();

    public Flyweight factory(Character state) {
        //先从缓存中查找对象
        Flyweight fly = files.get(state);
        if (fly == null) {
            //如果对象不存在则创建一个新的Flyweight对象
            fly = new ConcreteFlyweight(state);
            //把这个新的Flyweight对象添加到缓存中
            files.put(state, fly);
        }
        return fly;
    }
}