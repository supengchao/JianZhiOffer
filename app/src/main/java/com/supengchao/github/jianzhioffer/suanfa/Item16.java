package com.supengchao.github.jianzhioffer.suanfa;

import java.util.Stack;

/**
 * Created by supengchao on 17/2/9.
 * 反转链表
 * 题目：
 * 对于一个链表，反转该链表并返回头结点。
 * 思路：
 * 主要是指针的操作，但是要注意不能断链。这里可以使用非递归的方式求解。
 */

public class Item16 {

    public static void main(String args[]) {
        DeleteListNode.ListNode node1 = new DeleteListNode.ListNode(1);
        DeleteListNode.ListNode node2 = new DeleteListNode.ListNode(2);
        DeleteListNode.ListNode node3 = new DeleteListNode.ListNode(3);
        DeleteListNode.ListNode node4 = new DeleteListNode.ListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(null);
        DeleteListNode.ListNode node5 = reverseNodeList(node1);
        printListNode(node5);
    }

    public static DeleteListNode.ListNode reverseNodeList(DeleteListNode.ListNode head) {
//        DeleteListNode.ListNode node = head.getNext();
//        if (node != null) {
//            node.setNext(head);
//        }

        DeleteListNode.ListNode reservedHead = null;
        DeleteListNode.ListNode pNode = head;
        DeleteListNode.ListNode pPrev = null;
        while (pNode != null) {
            DeleteListNode.ListNode pNext = pNode.getNext();

            if (pNext == null) {
                reservedHead = pNode;
            }

            pNode.setNext(pPrev);
            pPrev = pNode;
            pNode = pNext;
        }
        return reservedHead;

    }

    public static void printListNode(DeleteListNode.ListNode node) {
        DeleteListNode.ListNode temp = node;
        while (temp.getNext() != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }
}
