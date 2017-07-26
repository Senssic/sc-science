package com.sc.science.arithmetic.str;

/**
 * 旋转字符串,给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部， 如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，
 * 使得原字符串变成字符串“cdefab”。请写一个函数完成此功能， 要求对长度为n的字符串操作的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class RotateStr {
    /**
     * 1.暴力位移 时间复杂度:O(m * n) 空间复杂度:O(1)
     *
     * @param str 待处理的字符串
     * @param m   需要将前几位移动到尾部
     */
    public static String leftRotateString(String str, int m) {
        char[] strs = str.toCharArray();
        int n = str.length();
        while (m-- > 0) {
            char t = strs[0];
            for (int i = 1; i < n; i++) {
                strs[i - 1] = strs[i];
            }
            strs[n - 1] = t;
        }
        return new String(strs);
    }

    /**
     * 反转私有方法
     *
     * @param s    待反转的字符串
     * @param from 反转的开始位置
     * @param to   反转的结束位置
     */
    private static String reverseString(char[] s, int from, int to) {
        while (from < to) {
            char t = s[from];
            s[from++] = s[to];
            s[to--] = t;
        }
        return new String(s);
    }

    /**
     * 2.三步反转法 将一个字符串分成X和Y两个部分，在每部分字符串上定义反转操作，如X^T，即把X的所有字符反转（如，X="abc"，那么X^T="cba"），那么就得到下面的结论：(X^TY^T)^T=YX，显然就解决了字符串的反转问题。
     *
     * 例如，字符串 abcdef ，若要让def翻转到abc的前头，只要按照下述3个步骤操作即可：
     *
     * (1).首先将原字符串分为两个部分，即X:abc，Y:def；
     * (2).将X反转，X->X^T，即得：abc->cba；将Y反转，Y->Y^T，即得：def->fed。
     * (3).反转上述步骤得到的结果字符串X^TY^T，即反转字符串cbafed的两部分（cba和fed）给予反转，cbafed得到defabc，形式化表示为(X^TY^T)^T=YX，这就实现了整个反转。
     *时间复杂度:O(n)
     * 空间复杂度O(1)
     * @param str 待处理的字符串
     * @param m   需要移动到尾部的字符串位置
     */
    public static String leftRotateString2(String str, int m) {
        int n = str.length();
        char[] s = str.toCharArray();
        m %= n;
        reverseString(s, 0, m - 1);
        reverseString(s, m, n - 1);
        reverseString(s, 0, n - 1);
        return new String(s);
    }

    public static void main(String[] args) {
        System.out.println("-->" + RotateStr.leftRotateString("abcdef", 2));
        System.out.println("-->" +RotateStr.leftRotateString2("abcdef", 2));
        Double.valueOf("102");
    }
}
