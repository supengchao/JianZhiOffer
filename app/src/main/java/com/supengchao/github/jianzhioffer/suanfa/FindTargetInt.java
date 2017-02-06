package com.supengchao.github.jianzhioffer.suanfa;

/**
 * Created by supengchao on 17/1/18.
 *  对于一个m*n的整数矩阵，其中每一行和每一列的元素都按升序排列，
 *  设计一个高效的算法判断一个数值是否存在，并给出位置
 */

public class FindTargetInt {

    public static String findTargetInt(int[][] matrx, int value) {
        int row = 0;
        int colume = 0;
        while (row < matrx.length) {
            int maxLength = matrx[row].length-1;
            if (matrx[row][colume] <= value && matrx[row][maxLength] >= value) {
                for (int i = 0; i < matrx[row].length; i++) {
                    if (matrx[row][i] == value) {
                        return "matrx[" + row + "][" + i + "]";
                    }
                }
            } else {
                row++;
            }

        }
        return "matrx[-1][-1]";
    }

    /**
     * 二维数组的查找
     * @param array 已知的数组
     * @param number 待查找的数
     * @return
     */
    public static boolean find(int array[][], int number) {
        boolean flag = false;
        int rows = array.length;// 行数
        int columns = array[0].length;// 列数
        int row = 0;
        int column = columns - 1;
        while (row < rows && column >= 0) {
            // 比较二维数组中的元素与number的关系
            if (array[row][column] == number) {
                flag = true;
                break;// 跳出循环
            } else if (array[row][column] > number) {
                // 列变小
                column--;
            } else {
                // 行变大
                row++;
            }
        }
        return flag;
    }

    public static void main(String[] args){
        int matrix[][] = { { 1, 2, 3 }, { 4, 5 }, { 7, 8, 9 } };
//        System.out.print(find(matrix,10));
        System.out.print(findTargetInt(matrix,10));
    }
}
