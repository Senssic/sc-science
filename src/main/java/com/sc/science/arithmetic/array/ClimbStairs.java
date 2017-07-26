package com.sc.science.arithmetic.array;

/**
 * 跳台阶问题
 *
 * 一个台阶总共有n 级，如果一次可以跳1 级，也可以跳2 级。
 *
 * 求总共有多少总跳法
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class ClimbStairs {
    /**
     * 1.fibonacci数列问题,使用递归
     *
     * @param n 台阶级数
     */
    public static Integer fibonacci(Integer n) {
        int[] result = {0, 1, 2};
        if (n <= 2) {
            return result[n];
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 用的递归的方法有许多重复计算的工作，
     *
     * 事实上，我们可以从后往前推，
     *
     * 一步步利用之前计算的结果递推。
     */
    public static Integer climbStairs(Integer n) {
        int[] dp = {1, 1,0};
        if (n < 2) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            dp[2] = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = dp[2];
        }
        return dp[2];
    }

    public static void main(String[] args) {
        System.out.println("-->" +fibonacci(10));
        System.out.println("-->" +climbStairs(10));
    }
}
