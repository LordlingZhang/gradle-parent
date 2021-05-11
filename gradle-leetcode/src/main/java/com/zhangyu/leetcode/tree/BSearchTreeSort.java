package com.zhangyu.leetcode.tree;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * @author zhangyu
 * @description: 二叉查找树遍历
 * 树定义：   左子节点 < 当前节点 < 右子节点
 * @date 2021/5/10
 */
@Slf4j
public class BSearchTreeSort {

    private TreeNode treeNode;

    BSearchTreeSort(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

    /**
     * 遍历查找树中值为d的节点
     *
     * @param d
     */
    public TreeNode find(int d) {
        // 从根节点开始
        TreeNode p = treeNode;
        while (p != null) {
            if (d < p.getData()) {
                p = p.getLNode();
            } else if (d > p.getData()) {
                p = p.getRNode();
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 插入
     *
     * @param d
     */
    public void insert(int d) {
        TreeNode inode = new TreeNode(d);
        TreeNode p = treeNode;
        while (p != null) {
            // 大于当前，则遍历当前节点 右侧；为空的话，直接替换
            if (d > p.getData()) {
                if (p.getRNode() == null) {
                    p.setRNode(inode);
                    return;
                }
                p = p.getRNode();
            } else {
                if (p.getLNode() == null) {
                    p.setLNode(inode);
                    return;
                }
                p = p.getLNode();
            }
        }
    }

    /**
     * 删除
     *
     * @param d
     */
    public void delete(int d) {
        // 查找需要删除的节点

        // 当前节点为 根节点 -> 直接删除

        // 当前节点 有一个子节点 -> 用子节点替换当前

        // 当前节点 有两个子节点 -> 找到右节点中最小的a，替换当前,然后把a的右节点换到a的位置
    }

    public static void main(String[] args) {
        LinkedList<Integer> a = new LinkedList(Arrays.asList(6, 3, 2, 1, null, null, null, 4, null, null, 8, 7, null,
                null, 9, null, null));
        TreeNode treeNode = TreeNode.createBinaryTree(a);
        BSearchTreeSort treeSort = new BSearchTreeSort(treeNode);
        // 查找
        TreeNode findNode = treeSort.find(2);
        System.out.println("节点:" + findNode.getData() + "  左节点:" + (findNode.getLNode() == null ? "null" :
                findNode.getLNode().getData()) + "  右节点:" + (findNode.getRNode() == null ? "null" :
                findNode.getRNode().getData()));
        // 插入
        treeSort.insert(5);
        System.out.println();
    }
}
