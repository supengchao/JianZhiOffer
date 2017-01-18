package com.supengchao.github.jianzhioffer.sort;

/**
 * Created by supengchao on 17/1/9.
 */

public class SortOfInsertion {
    public static void main(String args[]) {
//        int[] arr = {1,3,5,7,9,10,13,14,17,18,20,23};
//        System.out.print("POS="+getIndex(arr,7));

//        int[] arr = {12, 1, 34, 23, 56, 59, 10, 8, 7, 13, 90, 123};
//        insertionSort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(i + "=" + arr[i]);
//        }
        testI();
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int left = 0;
            int right = i - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (key < arr[mid]) {
                    right = mid - 1;
                } else if (key > arr[mid]) {
                    left = mid + 1;
                }
            }
            //将原来的有序序列整体右移移位
            for (int j = i - 1; j >= left; j--) {
                arr[j + 1] = arr[j];
            }
            //上面右移完成后，将当前值填充到left的位置
            arr[left] = key;
        }
    }

    /**
     * 二分查找，仅限于对有序序列
     * @param arr
     * @param value
     * @return
     */
    public static int getIndex(int[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;

        while ((left <= right) && (left <= arr.length - 1) && (right <= arr.length - 1)) {
            int mid = (left + right) >> 2;
            if (value == arr[mid]) {
                return mid;
            } else if (value < arr[mid]) {
                right = mid - 1;
            } else if (value > arr[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void testI(){
        int i=0;
        System.out.println("i="+(++i));


        int j=0;
        System.out.println("j="+(j++));
    }
}
