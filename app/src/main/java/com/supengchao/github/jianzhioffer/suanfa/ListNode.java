package com.supengchao.github.jianzhioffer.suanfa;

import java.util.Stack;

/**
 * Created by supengchao on 17/1/19.
 * 从尾到头打印链表
 */

public class ListNode  {
    public static void main(String[] args){
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(null);
        System.out.println("第一种方式，递归实现：");
        listReverse1(head);
        System.out.println("第二种方式，非递归实现：");
        listReverse2(head);
    }

    /**
     * 递归
     * @param head
     */
    public static void listReverse1(Node head){
        if(head!=null){
            if(head.getNext()!=null){
                listReverse1(head.getNext());
            }
            System.out.println(head.getValue()+",");
        }
    }

    /**
     * STACK
     */
    public static void listReverse2(Node head){
        Stack<Integer> stack = new Stack<>();
        while(head!=null){
            stack.push(head.getValue());
            head = head.getNext();
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop()+".");
        }

    }

    static class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
