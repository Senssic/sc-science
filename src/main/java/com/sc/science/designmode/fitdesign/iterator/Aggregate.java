package com.sc.science.designmode.fitdesign.iterator;

/**
 *集合接口,创建iterator接口
 * @author qiss
 */
public interface Aggregate {
    /**
     * 创建迭代器的方法
     * @return
     */
    public abstract Iterator iterator();
}
