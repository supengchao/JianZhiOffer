package com.supengchao.github.jianzhioffer.suanfa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by supengchao on 17/2/9.
 * 链表中倒数第k个结点
 * <p>
 * 题目：
 * 在一个链表里找到倒数第K个结点
 * 思路：
 * 1、可以用有序序列List获取倒数第K个结点的值
 * 2、 使用双指针的方式，前一个指针先走k步(中间隔k-1个结点)，
 * 后一个指针才开始走，直到第一个指针走到尾，后一个指针指向的就是要找的倒数第k个数。
 * 值得注意的是：1、k是否超过链表长度且k必须为正整数；2、链表是否为空。
 */

public class Item15 {

    /**
     * 可以用有序序列List获取倒数第K个结点的值
     *
     * @param head
     * @param k
     * @return
     */
    public static DeleteListNode.ListNode findTheLastKNode(DeleteListNode.ListNode head, int k) {
        List<DeleteListNode.ListNode> list = new ArrayList<>();
        list.clear();
        DeleteListNode.ListNode node = head;
        if (head == null || k <= 0) {
            return null;
        }
        while (node.getNext() != null) {
            list.add(node);
            node = node.getNext();
        }
        if (node.getNext() == null) {
            list.add(node);
        }
        if (list.size() < k) {
            return null;
        }
        return list.get(list.size() - 1 - (k - 1));

    }

    public static DeleteListNode.ListNode findTheLastKNode1(DeleteListNode.ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        DeleteListNode.ListNode preNode = head;
        DeleteListNode.ListNode postNode = head;

        for (int i = 0; i < k - 1; i++) {
            if (preNode.getNext() != null) {
                preNode = preNode.getNext();
            } else {
                return null;
            }
        }
        while (preNode.getNext() != null) {
            preNode = preNode.getNext();
            postNode = postNode.getNext();
        }
        return postNode;

    }

    public static void main(String args[]) {
        DeleteListNode.ListNode node1 = new DeleteListNode.ListNode(1);
        DeleteListNode.ListNode node2 = new DeleteListNode.ListNode(2);
        DeleteListNode.ListNode node3 = new DeleteListNode.ListNode(3);
        DeleteListNode.ListNode node4 = new DeleteListNode.ListNode(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(null);
        DeleteListNode.ListNode node = findTheLastKNode(node1, 3);
        DeleteListNode.ListNode res = findTheLastKNode1(node1, 3);
        System.out.print(node == null ? "空" : node.getValue());
        System.out.print(node == null ? "空" : res.getValue());

    }
}
