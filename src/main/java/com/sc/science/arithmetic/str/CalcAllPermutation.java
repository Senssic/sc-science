package com.sc.science.arithmetic.str;

/**
 * 字符串全排列 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 例如输入字符串abc，则输出由字符a、b、c 所能排列出来的所有字符串
 *
 * abc、acb、bac、bca、cab 和 cba。
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CalcAllPermutation {
    /**
     * 1. 固定a, 求后面bc的全排列： abc, acb。 求完后，a 和 b交换； 得到bac,开始第二轮
     *
     * 2. 固定b, 求后面ac的全排列： bac, bca。 求完后，b 和 c交换； 得到cab,开始第三轮
     *
     * 3. 固定c, 求后面ba的全排列： cab, cba
     *
     * 时间复杂度:O(n！)
     * 空间复杂度:O(1)
     */
    public static void permutation(char[] s, int from, int to) {
        if (to < 1) {
            return;
        }
        if (from == to) {
            System.out.println(new String(s));
        } else {
            for (int i = from; i <= to; i++) {
                swap(s, i, from);//每次递归将i位置的值移动到第一位
                permutation(s, from + 1, to);
                swap(s, from, i);
            }
        }

    }

    /**
     * 交换
     */
    public static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        String str = "abc";
        CalcAllPermutation.permutation(str.toCharArray(), 0, str.length() - 1);
    }


}
