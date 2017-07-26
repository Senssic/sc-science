package com.sc.science.arithmetic.array;

import java.util.Arrays;

/**
 * 荷兰国旗问题
 *
 *  现有n个红白蓝三种不同颜色的小球，乱序排列在一起，请通过两两交换任意两个球，使得从左至右，依次是一些红球(0)、一些白球(1)、一些蓝球(2)。
 *
 * @auth:qiss
 * @see: [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DutchFlag {
    /**
     * 交换
     */
    public static void swap(int[] s, int i, int j) {
        int temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }


    public static int[] culDutchFlag(int[] someFlag){
        int current=0;
        int begin=0;
        int end=someFlag.length-1;
        int i=0;
        while(current<=end){
            if(someFlag[current]==0){//如果是红球则和之前定位的begin交换使得红球都位于第一位列
                swap(someFlag,current,begin);
                current++;
                begin++;
            }else if(someFlag[current]==1){//如果是白球则一直往后走
                current++;
            }else{//someFlag[current]==2,如果是篮球则与最后一位交换
                swap(someFlag,current,end);
                end--;
            }
        }
        return someFlag;
    }

    public static void main(String[] args) {
        int [] someflag={0,1,0,0,0,1,1,1,2,1,0,1,2,2,1,0,2,2,2,1,2,0,1,2,0,1,0,1,1,0,0,2,2,1,0,2};
        System.out.println("-->" + Arrays.toString(DutchFlag.culDutchFlag(someflag)));
    }
}
