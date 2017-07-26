package com.sc.science.arithmetic.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串全组合
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class CalAllCombination {
    /**
     * 1.递归方法
     *
     * 在求一个字符串中所有字符的组合的时候，针对一个字符，有两种情况，假设在长度为n的字符串中选择长度为m的组合字符串，
     *
     * 第一是选择长度为n的字符串中的第一个字符，那么要在其余的长度n-1的字符串中选择m-1个字符
     *
     * 第二是不选择长度为n的字符串中的第一个字符，那么要在其余的长度n-1的字符串中选择m个字符
     *
     * 递归结束的条件就是，当m为0，即从字符串中不再选出字符的时候，这个时候已经找到了m个字符的组合，输出即可。还有一个条件是，当输入的字符串是串，自然是不能从中选出任何字符的。
     */
    public static void perm(String s) {
        List<String> result = new ArrayList<String>();
        for (int i = 1; i <= s.length(); i++) {
            perm(s, i, result);
        }
    }

    // 从字符串s中选择m个字符
    public static void perm(String s, int m, List<String> result) {
        // 如果m==0，则递归结束。输出当前结果
        if (m == 0) {
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
            }
            System.out.println();
            return;
        }
        if (s.length() != 0) {
            // 选择当前元素
            result.add(s.charAt(0) + "");
            perm(s.substring(1, s.length()), m - 1, result);
            result.remove(result.size() - 1);
            // 不选当前元素
            perm(s.substring(1, s.length()), m, result);
        }
    }

    /**
     * 2.基于位图。
     *
     * 假设原有元素n个，最终的组合结果有2^n - 1. 可以使用2^n - 1个位，1表示取该元素，0表示不取。 所以a表示001,取ab是011。
     * 001,010,011,100,101,110,111。对应输出组合结果为：a,b,ab,c,ac,bc,abc。 因此可以循环
     * 1~2^n-1(字符串长度)，然后输出对应代表的组合即可。
     */
    public static void Combination(char[] s) {
        if (s.length == 0) {
            return;
        }
        int len = s.length;
        int n = 1 << len;
        //从1循环到2^len-1
        for (int i = 0; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            //查看第一层循环里面的任意一种取值当中的哪一位是1[比如ab,011]， 如果是1，对应的字符就存在，打印当前组合。
            for (int j = 0; j < len; j++) {
                if ((i & (1 << j)) != 0) // 对应位上为1，则输出对应的字符
                {
                    sb.append(s[j]);
                }
            }
            System.out.print(sb + " ");
        }
    }

    public static void main(String[] args) {
        CalAllCombination.perm("abcd");
        CalAllCombination.Combination("abcd".toCharArray());
        System.out.println("-->".indexOf(">"));
    }
}
