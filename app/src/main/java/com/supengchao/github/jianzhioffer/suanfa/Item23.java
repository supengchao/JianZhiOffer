package com.supengchao.github.jianzhioffer.suanfa;

import java.util.*;

/**
 * Created by supengchao on 17/2/10.
 * 从上往下打印二叉树
 * 题目大致为：
 * 从上往下打印出儿茶树的每个结点，同一层的结点按照从左到右的顺序打印。
 * 思路：
 * 可以使用队列的方式存储，先将根结点入队，若队列不为空，则取出队列的头，
 * 若这个结点有左孩子，则左孩子入队，若有右孩子，则右孩子入队。
 */

public class Item23 {

    public static void main(String[] args){
        Item19.TreeNode node1 = new Item19.TreeNode(1);
        Item19.TreeNode node2 = new Item19.TreeNode(2);
        Item19.TreeNode node3 = new Item19.TreeNode(3);
        Item19.TreeNode node4 = new Item19.TreeNode(4);
        Item19.TreeNode node5 = new Item19.TreeNode(5);

        node1.setLeftNode(node2);
        node1.setRightNode(node3);
        node2.setLeftNode(node4);
        node3.setRightNode(node5);

    }

    public static void printNode(Item19.TreeNode head){
        java.util.Queue<Item19.TreeNode> queue = new LinkedList<>();
        queue.add(head);

        while(!queue.isEmpty()){
            Item19.TreeNode treeNode = queue.poll();
            System.out.println(treeNode.getValue());
        }
    }
}
