package com.sc.science.arithmetic.swordoffer;

/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * @auth:senssic
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Day07_费波纳茨数列 {

    public static int Fibonacci(int n) {
        return n<2? (n<1?0:1) : Fibonacci(n-1)+Fibonacci(n-2);
    }



    public static void main(String[] args) {

    }


}
