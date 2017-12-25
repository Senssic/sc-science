package com.sc.science.designmode.visitdatastructure.visitor;

/**
 * 访问者接口
 * @author qiss
 */
public abstract class Visitor {
    /**
     * 访问文件
     * @param file
     */
    public abstract void visit(File file);

    /**
     * 访问文件夹
     * @param directory
     */
    public abstract void visit(Directory directory);
}
