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
public class Day01_二维数组中的二分查找 {

    /**
     * 四角选择一个角进行搜索,一般选择右上或左下进行搜索
     * 因为左上或右下数据太极端,
     * 当然还可以采用二分法遍历但是时间复杂度高一些
     * @param target
     * @param array
     * @return
     */
    public static boolean Find(int target, int[][] array) {
        int rows = array.length;
        int cols = array[0].length;
        if (array==null || rows<1 || cols<1){
            return false;
        }
        int row = 0;
        int col = cols-1;
        while (row<rows && col>=0){
            if (array[row][col] == target){
                return true;
            } else if (array[row][col] < target){
                row++;
            } else {
                col--;
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
        System.out.println("-->" + Find(4,array));
        int ars[][]={};
        System.out.println("-->" + Find(4,ars));


    }
}
