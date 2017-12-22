package com.sc.science.designmode.fitdesign.iterator;

/**
 * 具体需要被迭代处理的实例
 *
 * @author qiss
 */
public class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
