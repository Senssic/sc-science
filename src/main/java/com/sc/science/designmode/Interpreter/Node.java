package com.sc.science.designmode.Interpreter;

public abstract class Node {
    public abstract void parse(Context context) throws ParseException;
}
