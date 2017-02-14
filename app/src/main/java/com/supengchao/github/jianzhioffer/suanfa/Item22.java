package com.supengchao.github.jianzhioffer.suanfa;

import java.util.Stack;

/**
 * Created by supengchao on 17/2/10.
 * 栈的压入、弹出序列
 * 题目大致为：
 * 输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否为该栈的弹出顺序。
 * 思路：
 * 主要分为这样的几种情况：首先判断两个序列的长度是否相等，
 * 若相等且大于0，则利用辅助栈模拟入栈和出栈。
 * 如果栈为空，则入栈，此时若栈顶元素与出栈序列的第一个元素相等，
 * 则出栈，否则继续入栈，最后判断栈是否为空且出栈序列所有的元素都遍历完。
 */

public class Item22 {

    public static void main(String[] args) {
        // 测试用例
        // 第一组
        int pushArray_1[] = {1, 2, 3, 4, 5};
        int popArray_1[] = {4, 5, 3, 2, 1};
        System.out.println("第一组：" + doesPopOrder(pushArray_1, popArray_1));
        System.out.println("第一组：" + isPopOrder(pushArray_1, popArray_1));

        // 第二组
        int pushArray_2[] = {1, 2, 3, 4, 5};
        int popArray_2[] = {4, 3, 5, 1, 2};
        System.out.println("第二组：" + doesPopOrder(pushArray_2, popArray_2));
        System.out.println("第二组：" + isPopOrder(pushArray_2, popArray_2));

        // 第三组，主要长度不等
        int pushArray_3[] = {1, 2, 3, 4, 5};
        int popArray_3[] = {4, 5, 3};
        System.out.println("第三组：" + doesPopOrder(pushArray_3, popArray_3));
        System.out.println("第三组：" + isPopOrder(pushArray_3, popArray_3));

        // 第四组
        int pushArray_4[] = {1, 2, 3, 4, 5};
        int popArray_4[] = {5, 4, 3, 2, 1};
        System.out.println("第四组：" + doesPopOrder(pushArray_4, popArray_4));
        System.out.println("第四组：" + isPopOrder(pushArray_4, popArray_4));

    }

    /**
     * 自己写的，感觉网上的有问题，留下个疑惑
     * @param pushArray
     * @param popArray
     * @return
     */
    public static boolean doesPopOrder(int[] pushArray, int[] popArray) {
        boolean isPopOrder = false;

        if (pushArray.length > 0 && pushArray.length == popArray.length) {
            Stack<Integer> stack = new Stack<>();
            stack.clear();
            for (int i = 0; i < pushArray.length; i++) {
                stack.push(pushArray[i]);
            }

            for (int i = 0; i < popArray.length; i++) {
                if (!stack.empty()) {
                    if (stack.pop() != popArray[i]) {
                        isPopOrder = false;
                        break;
                    }
                }
                if (i == popArray.length - 1) {
                    isPopOrder = true;
                }
            }

        }

        return isPopOrder;
    }

    /**
     * 判断序列popArray是否为pushArray的出栈序列
     *
     * @param pushArray
     *            入栈序列
     * @param popArray
     *            出栈序列
     * @return boolean
     */
    public static boolean isPopOrder(int pushArray[], int popArray[]) {
        boolean flag = false;
        // 能够执行的条件是这样的序列不为空，而且两个序列的长度是相等的
        if (pushArray.length > 0 && pushArray.length == popArray.length) {
            // 构造一个辅助栈，模拟入栈和出栈
            Stack<Integer> stack = new Stack<Integer>();
            int i = 0;
            int j = 0;

            // 保证入栈序列全进入栈
            while (i < pushArray.length) {
                // 当栈非空时，若栈顶元素与出栈序列中的元素相同，则出栈
                if (stack.size() > 0 && stack.peek() == popArray[j]) {
                    stack.pop();
                    j++;
                } else {// 若不相同或者栈为空，则在入栈序列中继续增加
                    stack.push(pushArray[i]);
                    i++;
                }
            }
            // 此时栈中还有元素需要与出栈序列对比
            while (stack.size() > 0) {
                // 若果相等就出栈
                if (stack.peek() == popArray[j]) {
                    stack.pop();
                    j++;
                } else {//若不相等就直接退出
                    break;
                }
            }
            // 最终如果栈是空的，而且popArray中的所有数都遍历了，则是出栈序列
            if (stack.isEmpty() && j == popArray.length) {
                flag = true;
            }
        }
        return flag;
    }
}
