package com.supengchao.github.jianzhioffer.suanfa;

/**
 * Created by supengchao on 17/1/18.
 * http://www.cnblogs.com/liuweilinlin/p/3320431.html
 * 楼梯有n个台阶，上楼可以一步上1阶，也可以一步上2阶，一共有多少种上楼的方法？
 * 一枚均匀的硬币掷n次，问不连续出现正面的可能情形有多少种？
 */

public class StepProblem {
    public static void main(String[] args) {
//        System.out.print(fstep(11));
        System.out.print(newfStep(12));

    }

    /**
     * 递归的方式实现，缺点是时间复杂度很高，重复计算
     *
     * @param n
     * @return
     */
    public static int fstep(int n) {

        System.out.println("n=" + n);
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n >= 3) {
            return fstep(n - 1) + fstep(n - 2);
        }
        return 0;
    }

    /**
     * 不使用递归，减小时间复杂度的实现方式
     * @param n
     * @return
     */
    public static int newfStep(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.println("i=" + i);
            System.out.println("C=" + c);
        }
        return c;
    }
}
