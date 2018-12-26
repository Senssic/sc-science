package com.sc.science.arithmetic.swordoffer;

/**
 * 题目描述: 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串
 * 为We%20Are%20Happy。
 *
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Day02_替换空格 {
    public static String replaceSpace(StringBuffer str) {
        char[] chars = str.toString().toCharArray();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                count++;
            }
        }
        //计算空间恰好放得下新生成的3个字符
        int p = chars.length - 1;
        int p2 = count * 2 + p;
        char[] newchars = new char[p2+1];

        while (p >= 0) {
            if (chars[p] == ' ') {
                newchars[p2--] = '0';
                newchars[p2--] = '2';
                newchars[p2--] = '%';
            } else {
                newchars[p2--] = chars[p];
            }
            p--;
        }
        return new String(newchars);
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("hello%20world");
        replaceSpace(stringBuffer);
    }
}
