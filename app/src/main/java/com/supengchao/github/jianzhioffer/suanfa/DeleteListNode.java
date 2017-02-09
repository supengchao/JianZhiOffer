package com.supengchao.github.jianzhioffer.suanfa;

/**
 * Created by supengchao on 17/2/8.
 * 题目大致为：
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 * 思路：
 * 想要在O(1)时间内删除链表的指定结点，要遍历的话得O(n)，则肯定不能遍历。若是要删除的结点不是尾结点，
 * 那么可以将后面的那个值复制到该指针处，并将后面指针所指空间删除，用复制+删除后面的实现删除，时间复杂度为O(1)。
 * 对于尾结点，需要遍历，那么时间复杂度是O(n)，但是总的时间复杂度为[(n-1)*O(1)+O(n)]/n，结果是O(1)。
 */

public class DeleteListNode {
    static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(null);

        printNode(head);
        System.out.println("--------");
        deleteNode(head, node2);
        System.out.println("--------");
        printNode(head);
    }


    public static void printNode(ListNode node) {
        ListNode current = node;
        while (current != null) {
            System.out.println("value=" + current.getValue());
            current = current.getNext();
        }
    }

    public static void deleteNode(ListNode head, ListNode deleteNode) {
        if (head == null || deleteNode == null) {
            return;
        }
        if (deleteNode.getNext() != null) {
            ListNode d = deleteNode.getNext();
            deleteNode.setValue(d.getValue());
            deleteNode.setNext(d.getNext());
        } else if (head == deleteNode) {
            head = null;
        } else {
            ListNode node = head;
            while (node.getNext() != deleteNode) {
                node = node.getNext();
            }
            node.setNext(null);
        }


    }
}
