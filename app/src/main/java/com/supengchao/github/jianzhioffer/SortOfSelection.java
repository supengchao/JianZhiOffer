package com.supengchao.github.jianzhioffer;

/**
 * Created by supengchao on 17/1/9.
 */

public class SortOfSelection {
    /**
     * 空间复杂度O(N2)
     * @param array
     */
    public static void selectionSort(int[] array) {
        int len = array.length;//先获取整个数组的长度
        int temp;//临时变量，用于交换数据
        int minIndex;//记录最小值坐标
        for (int i = 0; i < len-1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 1, 34, 23, 56, 59, 10, 8, 7, 13, 90, 123};
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "=" + arr[i]);
        }
    }
}
