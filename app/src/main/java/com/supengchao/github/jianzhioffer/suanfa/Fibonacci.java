package com.supengchao.github.jianzhioffer.suanfa;

/**
 * Created by supengchao on 17/2/7.
 */

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(13));
        System.out.println(fibonacci1(13));
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            // zero  one  fn
            int zero = 0;
            int one = 1;
            int fn = 0;
            for (int i = 2; i <= n; i++) {
                fn = zero + one;
                zero = one;
                one = fn;
            }
            return fn;
        }
    }

    public static int fibonacci1(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci1(n - 1) + fibonacci1(n - 2);
        }

    }
}
