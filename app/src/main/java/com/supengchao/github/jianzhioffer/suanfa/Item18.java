package com.supengchao.github.jianzhioffer.suanfa;

/**
 * Created by supengchao on 17/2/9.
 * <p>
 * 题目：输入两棵二叉树A和B，判断B是不是A的子结构。例如下图中的两棵二叉树，由于A中有一部分子树的结构和B是一样的，因此B是A的子结构。
 * 　　要查找树A中是否存在和树B结构一样的子树，我们可以分成两步：
 * <p>
 * 　　Step1.在树A中找到和B的根结点的值一样的结点R；
 * <p>
 * 　　Step2.判断树A中以R为根结点的子树是不是包含和树B一样的结构。
 * <p>
 * 　　很明显，这是一个递归的过程。
 */

public class Item18 {
    public static boolean HasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;

        if (root1 != null && root2 != null) {
            if (root1.Data == root2.Data) {
                result = DoesTree1HasTree2(root1, root2);
            }
            // 从根节点的左子树开始匹配Tree2
            if (!result) {
                result = HasSubTree(root1.leftChild, root2);
            }
            // 如果左子树没有匹配成功则继续在右子树中继续匹配Tree2
            if (!result) {
                result = HasSubTree(root1.rightChild, root2);
            }
        }

        return result;
    }

    private static boolean DoesTree1HasTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            // 证明Tree2已经遍历结束，匹配成功
            return true;
        }

        if (root1 == null) {
            // 证明Tree1已经遍历结束，匹配失败
            return false;
        }

        if (root1.Data != root2.Data) {
            return false;
        }
        // 递归验证左子树和右子树是否包含Tree2
        return DoesTree1HasTree2(root1.leftChild, root2.leftChild) && DoesTree1HasTree2(root1.rightChild, root2.rightChild);
    }

    static class BinaryTreeNode {
        public int Data;
        public BinaryTreeNode leftChild;
        public BinaryTreeNode rightChild;

        public BinaryTreeNode(int data) {
            this.Data = data;
        }

        public BinaryTreeNode(int data, BinaryTreeNode left, BinaryTreeNode right) {
            this.Data = data;
            this.leftChild = left;
            this.rightChild = right;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode nodeA1 = new BinaryTreeNode(8);
        BinaryTreeNode nodeA2 = new BinaryTreeNode(8);
        BinaryTreeNode nodeA3 = new BinaryTreeNode(9);
        BinaryTreeNode nodeA4 = new BinaryTreeNode(2);
        BinaryTreeNode nodeA5 = new BinaryTreeNode(5);

        nodeA1.rightChild = nodeA2;
        nodeA2.rightChild = nodeA3;
        nodeA3.rightChild = nodeA4;
        nodeA4.rightChild = nodeA5;

        BinaryTreeNode nodeB1 = new BinaryTreeNode(8);
        BinaryTreeNode nodeB2 = new BinaryTreeNode(9);
        BinaryTreeNode nodeB3 = new BinaryTreeNode(2);

        nodeB1.rightChild = nodeB2;
        nodeB2.rightChild = nodeB3;

        System.out.print(HasSubTree(nodeA1, nodeB1));
    }
}
