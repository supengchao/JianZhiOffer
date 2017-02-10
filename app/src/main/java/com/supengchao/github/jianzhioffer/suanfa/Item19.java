package com.supengchao.github.jianzhioffer.suanfa;

/**
 * Created by supengchao on 17/2/10.
 * 二叉树的镜像
 * 题目大致为：
 * 给定一棵二叉树，将其每一个结点的左右子树交换，这就叫做镜像。
 * 思路：
 * 先对其根节点的左右子树处理，交换左右子树，此时再递归处理左右子树。
 * 这里要注意分为三种情况：1、树为空；2、只有根结点；3、左右子树至少有一个不为空。
 */

public class Item19 {

    static class TreeNode {
        private int value;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(int value) {
            this.value = value;
        }

        public TreeNode(int value, TreeNode leftNode, TreeNode rightNode) {
            this.value = value;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public TreeNode getRightNode() {
            return rightNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }
    }

    public static void reverseTreeNode1(TreeNode head) {
        if (head == null || (head != null && head.getLeftNode() == null && head.getRightNode() == null)) {
            return;
        }
        TreeNode node = head;
        while (node.getLeftNode() != null) {
            reverseTreeNode(node);
            node = node.getLeftNode();
        }
        TreeNode node1 = head;
        while (node.getRightNode() != null) {
            reverseTreeNode(node1);
            node = node.getRightNode();
        }
    }

    public static void reverseTreeNode(TreeNode head) {
        if (head == null || (head != null && head.getLeftNode() == null && head.getRightNode() == null)) {
            return;
        }
        if (head.getLeftNode() != null && head.getRightNode() != null) {
            head.setLeftNode(head.getRightNode());
            head.setRightNode(head.getLeftNode());
            reverseTreeNode(head.getRightNode());
            reverseTreeNode(head.getLeftNode());
        } else if (head.getLeftNode() != null && head.getRightNode() == null) {
            head.setRightNode(head.getLeftNode());
            head.setLeftNode(null);
            reverseTreeNode(head.getLeftNode());
        } else {
            head.setLeftNode(head.getRightNode());
            head.setRightNode(null);
            reverseTreeNode(head.getRightNode());
        }
//        if((head.getLeftNode() != null){
//            reverseTreeNode(head.getLeftNode());
//        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node1.setLeftNode(node2);
        node2.setRightNode(node3);
        node3.setLeftNode(node4);
        node4.setRightNode(null);
        System.out.println( "--------");
        printPreOrder(node1);
        System.out.println( "--------");
//        reverseTreeNode(node1);
        mirrorRecursively(node1);
        printPreOrder(node1);
        System.out.println( "--------");
    }

    /**
     * 递归方式实现前序遍历输出
     * @param root
     */
    public static void printPreOrder(TreeNode root) {
        if (root != null) {
            System.out.println(root.getValue() + "、");
            printPreOrder(root.getLeftNode());
            printPreOrder(root.getRightNode());
        }
    }
    /**
     * 分三种情况：1、树为空；2、只有根结点；3、左右子树至少有一个不为空 对根结点的左右子树的处理方法与根结点的处理一致，可以采用递归的方式求解
     *
     * @param root
     */
    public static void mirrorRecursively(TreeNode root) {
        // 树为空
        if (root == null) {
            return;
        }
        // 只有一个根结点
        if (root.getLeftNode() == null && root.getRightNode() == null) {
            return;
        }

        // 左右子树至少有一个不为空
        root.setLeftNode(root.getRightNode());
        root.setRightNode(root.getLeftNode());

        // 递归求解左右子树
        if (root.getLeftNode() != null) {
            mirrorRecursively(root.getLeftNode());
        }

        if (root.getRightNode() != null) {
            mirrorRecursively(root.getRightNode());
        }
    }
}
