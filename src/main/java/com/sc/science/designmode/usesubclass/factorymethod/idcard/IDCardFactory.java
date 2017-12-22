package com.sc.science.designmode.usesubclass.factorymethod.idcard;


import com.sc.science.designmode.usesubclass.factorymethod.framework.Factory;
import com.sc.science.designmode.usesubclass.factorymethod.framework.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体的工厂类
 *
 * @author qiss
 */
public class IDCardFactory extends Factory {
    private List owners = new ArrayList();

    /**
     * 具体工厂的创建产品
     */
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    /**
     * 具体工厂的注册产品注册到某个用户上
     */
    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard) product).getOwner());
    }

    /**
     * 获取所有拥有者
     */
    public List getOwners() {
        return owners;
    }
}
