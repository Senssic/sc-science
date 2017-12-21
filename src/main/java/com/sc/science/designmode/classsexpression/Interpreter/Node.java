package com.sc.science.designmode.classsexpression.Interpreter;

public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
}
