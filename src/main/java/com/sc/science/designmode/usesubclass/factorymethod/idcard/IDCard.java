package com.sc.science.designmode.usesubclass.factorymethod.idcard;


import com.sc.science.designmode.usesubclass.factorymethod.framework.Product;

/**
 * 具体的产品
 *
 * @author qiss
 */
public class IDCard extends Product {
    private String owner;

    IDCard(String owner) {
        System.out.println("制作" + owner + "的ID卡。");
        this.owner = owner;
    }

    /**
     * 具体的使用规则
     */
    @Override
    public void use() {
        System.out.println("使用" + owner + "的ID卡。");
    }

    public String getOwner() {
        return owner;
    }
}
