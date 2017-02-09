package com.supengchao.github.jianzhioffer.suanfa;

/**
 * Created by supengchao on 17/2/9.
 * 合并两个排序的链表
 * 题目大致为：
 * 输入两个递增排序的链表，合并这两个链表并使得新链表中的结点仍然按照递增排序的。
 * 思路：
 * 主要是链表中值的比较，取较小的结点插入到新的链表中。
 */

public class Item17 {

    public static void main(String[] args) {
        DeleteListNode.ListNode node1 = new DeleteListNode.ListNode(1);
        DeleteListNode.ListNode node2 = new DeleteListNode.ListNode(2);
        DeleteListNode.ListNode node3 = new DeleteListNode.ListNode(3);
        DeleteListNode.ListNode node4 = new DeleteListNode.ListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(null);

        DeleteListNode.ListNode node5 = new DeleteListNode.ListNode(5);
        DeleteListNode.ListNode node6 = new DeleteListNode.ListNode(6);
        DeleteListNode.ListNode node7 = new DeleteListNode.ListNode(7);
        DeleteListNode.ListNode node8 = new DeleteListNode.ListNode(8);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node8);
        node8.setNext(null);

        printListNode(node1);
        System.out.println("----------");
        printListNode(node5);
        System.out.println("----------");
        printListNode(mergeList(node1, node5));

    }

    public static DeleteListNode.ListNode mergeList(DeleteListNode.ListNode listNode1, DeleteListNode.ListNode listNode2) {
        DeleteListNode.ListNode head = null;// 合并后的头指针
        // 如果有一个为空，则为另一个链表
        if (listNode1 == null) {
            head = listNode2;
        }
        if (listNode2 == null) {
            head = listNode1;
        }
        if (listNode1 != null && listNode2 != null) {
//            DeleteListNode.ListNode node_1 = listNode1;
//            DeleteListNode.ListNode node_2 = listNode2;

            if (listNode1.getValue() < listNode2.getValue()) {
                head = listNode1;
                head.setNext(mergeList(listNode2, listNode1.getNext()));
            } else {
                head = listNode2;
                head.setNext(mergeList(listNode1, listNode2.getNext()));
            }

        }
        return head;
    }


    public static void printListNode(DeleteListNode.ListNode node) {
        DeleteListNode.ListNode temp = node;
        while (temp.getNext() != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }
}
