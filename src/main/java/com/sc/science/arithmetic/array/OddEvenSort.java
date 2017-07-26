package com.sc.science.arithmetic.array;

import java.util.Arrays;

/**
 * 奇偶调序
 *
 * 输入一个整数数组，调整数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。要求时间复杂度为O(n)。
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class OddEvenSort {
    /**
     * 判断给定的数是不是奇数
     */
    private static boolean isOddNumber(int data) {
        return ((data & 1) == 1);
    }

    /**
     * 交换
     */
    public static void swap(int[] s, int i, int j) {
        int temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    /**
     * 1.两端同时向中间扫描如果不是对应的奇数偶数位置,则交换位置
     */
    public static void oddEvenSort(int[] pdata) {
        if (pdata == null || pdata.length == 0) return;
        int pbegin = 0;
        int pend = pdata.length - 1;
        while (pbegin < pend) {
            if (isOddNumber(pdata[pbegin])) {//如果pbegin是奇数,正常向右移动数组
                pbegin++;
            } else if (!isOddNumber(pdata[pend])) {//如果pend是偶数,正常向左移动
                pend--;
            } else {//如果都不是,交换数值
                swap(pdata, pbegin, pend);
            }
        }
    }

    public static void oddEvenSort2(int [] data){
        int i=-1;//数组第一位的前一位
        for(int j=0;j<data.length;j++){
            if(isOddNumber(data[j])){
                i=i+1;
                swap(data, i, j);
            }
        }
        swap(data,i + 1, data.length-1);
    }

    public static void main(String[] args) {
        int[] data = {10, 2, 3, 6, 7, 9, 5, 12, 23, 65};
        OddEvenSort.oddEvenSort(data);
        System.out.println("-->" + Arrays.toString(data));
        int[] data2 = {10, 2, 3, 6, 7, 9, 5, 12, 23, 65};
        OddEvenSort.oddEvenSort2(data2);
        System.out.println("-->" + Arrays.toString(data2));
    }
}
