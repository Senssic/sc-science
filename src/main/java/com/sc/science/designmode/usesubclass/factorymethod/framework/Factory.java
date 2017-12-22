package com.sc.science.designmode.usesubclass.factorymethod.framework;

/**
 * 抽象工厂
 * @author qiss
 */
public abstract class Factory {
    /**
     * 创建抽象产品
     * @param owner
     * @return
     */
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    /**
     * 创建产品具体交给子类做
     * @param owner
     * @return
     */
    protected abstract Product createProduct(String owner);

    /**
     * 注册产品具体交给子类做
     * @param product
     */
    protected abstract void registerProduct(Product product);
}
