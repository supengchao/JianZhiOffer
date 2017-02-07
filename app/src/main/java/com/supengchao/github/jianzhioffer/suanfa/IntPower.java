package com.supengchao.github.jianzhioffer.suanfa;

/**
 * Created by supengchao on 17/2/7.
 * 题目大致为：
 * 实现函数double power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 思路：
 * 可以考虑对指数折半，这样只需要计算一半的值，若指数是奇数，则-1再折半，否则直接折半。
 */

public class IntPower {

    public static void main(String args[]) {
        System.out.println(power(2, 2));
    }

    public static double power(double base, int exponent) {
        if (base == 1) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        if (exponent >> 1 == 0) {
            int half = exponent >> 1;
            double result = power(base, half);
            return result * result;
        } else {
            int half = exponent - 1;
            double result1 = power(base, half);
            return result1 * base;
        }

    }

}
