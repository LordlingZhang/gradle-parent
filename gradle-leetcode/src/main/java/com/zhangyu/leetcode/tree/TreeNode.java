package com.zhangyu.leetcode.tree;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author zhangyu
 * @description: 树节点
 * @date 2021-05-10 21:56:42
 */
@Slf4j
@Data
public class TreeNode {

    private int data;

    private TreeNode lNode;

    private TreeNode rNode;

    TreeNode(int data) {
        this.data = data;
    }

    /**
     * 构建树
     *
     * @param linkedList
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> linkedList) {
        if (CollectionUtils.isEmpty(linkedList)) {
            return null;
        }
        TreeNode node = null;
        // 每次取出第一个
        Integer data1 = linkedList.removeFirst();
        // 遇到null结束，说明下面没有子节点了
        if (data1 != null) {
            node = new TreeNode(data1);
            // 从左边开始一路到底
            node.lNode = createBinaryTree(linkedList);
            node.rNode = createBinaryTree(linkedList);
        }
        return node;
    }

    /**
     * 打印
     *
     * @param node
     */
//    public static void printNode(TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        System.out.print(node.data + " ");
//        printNode(node.lNode);
//        printNode(node.rNode);
//    }


    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        TreeNode treeNode = createBinaryTree(a);
//        printNode(treeNode);
    }
}
