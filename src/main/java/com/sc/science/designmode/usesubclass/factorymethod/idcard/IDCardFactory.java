package com.sc.science.designmode.usesubclass.factorymethod.idcard;


import com.sc.science.designmode.usesubclass.factorymethod.framework.Factory;
import com.sc.science.designmode.usesubclass.factorymethod.framework.Product;

import java.util.ArrayList;
import java.util.List;

public class IDCardFactory extends Factory {
    private List owners = new ArrayList();
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }
    public List getOwners() {
        return owners;
    }
}
