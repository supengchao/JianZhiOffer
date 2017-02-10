package com.supengchao.github.jianzhioffer.suanfa;

import java.util.Stack;

/**
 * Created by supengchao on 17/2/10.
 * 包含min函数的栈
 * 题目大致为：
 * 定义栈的数据结构，在给类型中实现一个能够得到栈的最小元素的min函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。
 * 思路：
 * 可以建一个辅助的栈，在插入的过程中，插入栈1，同时在插入辅助栈的过程中要求与栈中的元素比较，若小于栈顶元素，则插入该元素，若大于栈顶元素，则继续插入栈顶元素。
 */

public class Item21 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(3);
        minStack.push(2);
        System.out.println(minStack.min());
        System.out.println(minStack.pop());

    }

    static class MinStack {

        private Stack<Integer> stack;
        private Stack<Integer> stackHelper;

        public MinStack() {
            this.stack = new Stack<>();
            this.stackHelper = new Stack<>();
        }

        public void push(int i) {
            this.stack.push(i);
            if (stackHelper.empty() || i < stackHelper.peek()) {
                stackHelper.push(i);
            } else {
                stackHelper.push(stackHelper.peek());
            }
        }

        public int pop() {
            this.stackHelper.pop();
            return this.stack.pop();
        }

        public int min() {
            return this.stackHelper.peek();
        }
    }
}
