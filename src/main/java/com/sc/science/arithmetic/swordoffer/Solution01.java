package com.sc.science.arithmetic.swordoffer;

/**
 * 二维数据组的查找
 * 题目描述:
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class Solution01 {

    /**
     * 四角选择一个角进行搜索,一般选择右上或左下进行搜索
     * 因为左上或右下数据太极端,
     * 当然还可以采用二分法遍历但是时间复杂度高一些
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int[][] array) {
        int col = array.length-1;
        int row = 0;
        while((col >= 0)&& (row < array[0].length)){
            if(array[col][row] > target){
                col--;
            }else if(array[col][row] < target){
                row++;
            }else{
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[][] array = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };
        System.out.println("-->" +Solution01.Find(4,array));
        int ars[][]={};
        System.out.println("-->" +ars.length);
        System.out.println("-->" +ars[0].length);

    }
}
