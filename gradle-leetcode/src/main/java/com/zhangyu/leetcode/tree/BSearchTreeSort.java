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
        TreeNode delNode = treeNode;
        TreeNode pDelNode = null;// 待删除节点的父节点
        TreeNode wDelNode = null;// 待被指向的节点
        while (delNode != null && delNode.getData() != d) {
            pDelNode = delNode;
            if (d > delNode.getData()) {
                delNode = delNode.getRNode();
            } else {
                delNode = delNode.getLNode();
            }
        }
        if (delNode == null) {
            return;
        }

        // 当前节点为 叶子节点 -> 直接删除,父节点指向null
        if (delNode.getLNode() == null && delNode.getRNode() == null) {
            wDelNode = null;
//            if (pDelNode.getLNode() == delNode) {
//                pDelNode.setLNode(null);
//            } else {
//                pDelNode.setRNode(null);
//            }
        }
        // 当前节点 有一个子节点 -> 用子节点替换当前
        else if (delNode.getLNode() == null && delNode.getRNode() != null) {
//            if (pDelNode.getLNode() == delNode) {
//                pDelNode.setLNode(delNode.getRNode());
//            } else {
//                pDelNode.setRNode(delNode.getRNode());
//            }
            wDelNode = delNode.getRNode();
        } else if (delNode.getLNode() != null && delNode.getRNode() == null) {
//            if (pDelNode.getLNode() == delNode) {
//                pDelNode.setLNode(delNode.getLNode());
//            } else {
//                pDelNode.setRNode(delNode.getLNode());
//            }
            wDelNode = delNode.getLNode();
        }
        // 当前节点 有两个子节点 -> 找到右节点中最小的a，替换当前,然后把a的右节点换到a的位置
        else {
            // 先找到右节点中最小的
            TreeNode rMin = delNode.getRNode();
            TreeNode prMin = delNode; // 最小的节点的父节点
            while (rMin != null && rMin.getLNode() != null) {
                prMin = rMin;
                rMin = rMin.getLNode();
            }
            // 替换
            delNode.setData(rMin.getData());
//            if (prMin.getLNode() == rMin) {
//                prMin.setLNode(rMin.getRNode()); // 因为左侧最小，所以只可能有右孩子
//            } else {
//                prMin.setRNode(rMin.getRNode());
//            }
            pDelNode = prMin;
            wDelNode = rMin.getRNode();
        }

        // 判断删除节点的左右位置，删除开始
        if (pDelNode.getLNode() == delNode) {
            pDelNode.setLNode(wDelNode);
        } else {
            pDelNode.setRNode(wDelNode);
        }

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
        // 删除
        treeSort.delete(6);
        System.out.println();
    }
}
