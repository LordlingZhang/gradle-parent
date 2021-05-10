package com.zhangyu.leetcode.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zhangyu
 * @description: 二叉树排序 -> 使用递归的方式
 * @date 2021/5/10
 */
@Slf4j
public class BTreeSort {
    /**
     * 前序遍历
     * @param node
     */
    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preOrder(node.getLNode());
        preOrder(node.getRNode());
    }
    /**
     * 中序遍历
     * @param node
     */
    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.getLNode());
        System.out.print(node.getData() + " ");
        inOrder(node.getRNode());
    }
    /**
     * 后序遍历
     * @param node
     */
    public static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.getLNode());
        postOrder(node.getRNode());
        System.out.print(node.getData() + " ");
    }

    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        TreeNode treeNode = TreeNode.createBinaryTree(a);
        System.out.println("前序排列：");
        preOrder(treeNode);
        System.out.println("\n中序排列：");
        inOrder(treeNode);
        System.out.println("\n后序排列：");
        postOrder(treeNode);
    }
}
