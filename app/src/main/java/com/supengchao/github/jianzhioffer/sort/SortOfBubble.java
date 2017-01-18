package com.supengchao.github.jianzhioffer.sort;

/**
 * Created by supengchao on 17/1/9.
 */

public class SortOfBubble {
    /**
     * 冒泡排序-时间复杂性o（n2）
     * @param array
     */
    public static void sortBubble(int[] array){
        int i = array.length-1;
        int temp;
        while (i>0){
            int pos = 0;
            for(int j=0;j<i;j++){
                if(array[j+1]<array[j]){
                    pos=j;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] =temp;
                }
            }
            i=pos;
            System.out.println("POS="+i);
//            Log.d("TAG","POS="+i);
        }
    }

    public static void nomalBubbleSort(int[] arr){
        int temp;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j+1<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] =temp;
                }

            }
        }
    }

    public static void main(String[] arg){
        int[] arr = {12,1,34,23,56,59,10,8,7};
        nomalBubbleSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(i+"="+arr[i]);
        }
    }
}
