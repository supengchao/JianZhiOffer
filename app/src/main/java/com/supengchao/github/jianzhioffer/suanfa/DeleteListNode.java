package com.supengchao.github.jianzhioffer.suanfa;

/**
 * Created by supengchao on 17/2/8.
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
        deleteNode(head, head);
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
