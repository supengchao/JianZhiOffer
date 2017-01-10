package com.supengchao.github.jianzhioffer;

/**
 * Created by supengchao on 17/1/10.
 * 快速排序 时间复杂度 o(nlogn)
 */

public class SortOfQuickSort {
    public static void main(String[] args) {
        int[] arr = {12, 1, 34, 23, 23, 56, 59, 10, 8, 7, 13, 90, 123};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "=" + arr[i]);
        }
    }

    /**
     * 递归实现快速排序
     *
     * @param arr  数组
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int first = low;
        int last = high;
        int key = arr[low];
        while (first < last) {
            while (first < last && arr[last] >= key) {
                last--;
            }
            arr[first] = arr[last];
            while (first < last && arr[first] <= key) {
                first++;
            }
            arr[last] = arr[first];
        }
        arr[first] = key;
        quickSort(arr, low, first - 1);
        quickSort(arr, first + 1, high);
    }
}
