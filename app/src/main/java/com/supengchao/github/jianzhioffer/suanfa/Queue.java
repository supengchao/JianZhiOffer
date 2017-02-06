package com.supengchao.github.jianzhioffer.suanfa;

import java.util.Stack;

/**
 * Created by supengchao on 17/2/6.
 * 用两个栈实现队列的两个函数appendTail和deleteHead。
 * 思路：
 * 栈的特性是：后进先出，而队列的特性是：先进先出。
 * 这里使用两个栈实现队列有点负负得正的意思。栈1负责添加，而栈2负责删除
 */

public class Queue {
    public static void main(String[] args) {

        CQueue<Integer> cQueue = new CQueue<>();
        for (int i = 0; i < 5; i++) {
            cQueue.appendTail(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(cQueue.deleteHead());
        }
    }

    static class CQueue<T> {
        private Stack<T> stack1;
        private Stack<T> stack2;

        public CQueue() {
            this.stack1 = new Stack<>();
            this.stack2 = new Stack<>();
        }

        public void appendTail(T t) {
            stack1.push(t);
        }

        public T deleteHead() {
            if (stack2.size() == 0) {
                if (stack1.size() == 0) {
                    try {
                        throw new Exception("队列为空");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                while (stack1.size() > 0) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }
}
