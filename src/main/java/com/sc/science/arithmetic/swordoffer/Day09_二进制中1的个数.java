package com.sc.science.arithmetic.swordoffer;

/**
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 *
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Day09_二进制中1的个数 {
    public static int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf1(199);
    }
}
