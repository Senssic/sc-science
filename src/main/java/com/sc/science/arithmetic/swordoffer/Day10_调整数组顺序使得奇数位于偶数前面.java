package com.sc.science.arithmetic.swordoffer;

/**
 *题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分
 * ，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class Day10_调整数组顺序使得奇数位于偶数前面 {
    public void reOrderArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==1){
                int temp=array[i];
                int j=i-1;
                while(j>=0&&array[j]%2==0){
                    array[j+1]=array[j];
                    j--;
                }
                array[j+1]=temp;
            }
        }

    }

    public static void main(String[] args) {

    }
}
