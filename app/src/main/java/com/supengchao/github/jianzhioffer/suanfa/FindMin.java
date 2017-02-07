package com.supengchao.github.jianzhioffer.suanfa;

/**
 * Created by supengchao on 17/2/6.
 */

public class FindMin {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        System.out.print(findMin(arr));
    }

    public static int findMin(int[] arr) {
        int low = 0;
        int hight = arr.length - 1;
        int mid = low;

        while (arr[low] >= arr[hight]) {
            if (hight - low == 1) {
                mid = hight;
                break;
            }
            mid = (low + hight) / 2;
            if (arr[mid] <= arr[hight]) {
                hight = mid;
            } else if (arr[mid] >= arr[low]) {
                low = mid;
            }
        }
        return arr[mid];
    }

}
