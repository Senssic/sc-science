package com.sc.science.designmode.toinstance.prototype.framework;

/**
 * 原型接口,继承Cloneable接口,可被复制
 * @author qiss
 */
public interface Product extends Cloneable {
    /**
     * 具体方法
     * @param s
     */
    public abstract void use(String s);

    /**
     * 克隆原型实例的方法
     * @return
     */
    public abstract Product createClone();
}
