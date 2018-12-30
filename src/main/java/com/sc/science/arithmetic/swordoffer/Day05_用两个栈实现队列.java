package com.sc.science.arithmetic.swordoffer;

import java.util.Stack;

/**
 * 题目描述 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Day05_用两个栈实现队列 {
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    static public void push(int node) {
        stack1.push(node);
    }

    static public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                int node = stack1.pop();
                stack2.add(node);
            }
        }

        return stack2.pop();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        push(4);
        push(5);
        push(6);
        System.out.println("-->" +pop());
    }
}
