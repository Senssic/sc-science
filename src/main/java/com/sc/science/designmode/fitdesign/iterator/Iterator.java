package com.sc.science.designmode.fitdesign.iterator;

/**
 * 迭代器接口
 *
 * @author qiss
 */
public interface Iterator {
    /**
     * 是否还有下一个元素如果没有返回false
     * 如果有返回true
     *
     * @return 是否有下一个元素
     */
    public abstract boolean hasNext();

    /**
     * 获取当前元素
     */
    public abstract Object next();
}
