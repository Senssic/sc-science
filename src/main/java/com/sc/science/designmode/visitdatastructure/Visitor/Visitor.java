package com.sc.science.designmode.visitdatastructure.Visitor;

public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
}
