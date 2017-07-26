package com.sc.science.arithmetic.str;

/**
 * 判断是不是回文
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Palindrome {
    /**
     * 1.同时从两端向中间扫描,如果相等就是回文
     */
    public static boolean isPalindrome(final String str) {
        if (str.isEmpty()) {
            return false;
        }
        char[] s = str.toCharArray();
        int front = 0;
        int back = s.length - 1;
        while (front < back) {
            if (s[front] != s[back]) {
                return false;
            }
            ++front;
            --back;
        }
        return true;
    }

    /**
     * 1.从中间同时向两端扫描
     */
    public static boolean isPalindrome2(final String str) {
        if (str.isEmpty()) {
            return false;
        }
        char[] s = str.toCharArray();
        int mid = ((s.length >> 1) - 1) >= 0 ? (s.length >> 1) - 1 : 0;//右移一位相当于除以2
        int frist = mid;
        int secend = s.length - mid - 1;
        while (frist >= 0) {
            if (s[frist--] != s[secend++]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("-->" +isPalindrome("我是是啊爱是是我"));
        System.out.println("-->" +isPalindrome2("我是是啊爱啊是是我"));
    }

}
