package com.supengchao.github.jianzhioffer.suanfa;

/**
 * Created by supengchao on 17/2/7.
 * 二进制中1的个数
 * 题目大致为：
 * 实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * 思路：
 * 把一个整数减去1，再和原整数做与运算，会把最右边一个1变成0，那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
 */

public class FindIntBinaryOneCount {
    public static void main(String[] args) {
        System.out.print(findIntBinaryOneCount(7));
    }

    /**
     * 1000  --8
     * 0111  --7
     * 0000  --0
     * <p>
     * 0111--7
     * 0110--6
     * 0110--6
     * 0101--5
     * 0100--4
     * 0011--3
     * 0000
     *
     * @param i
     * @return
     */
    public static int findIntBinaryOneCount(int i) {
        int count = 0;
        while (i != 0) {
            count++;
            i = (i - 1) & i;
        }
        return count;
    }
}
