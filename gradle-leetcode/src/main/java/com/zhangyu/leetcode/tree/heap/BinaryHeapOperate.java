package com.zhangyu.leetcode.tree.heap;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author zhangyu
 * @description: 二叉堆  操作【构建、上浮、下沉】
 * 二叉堆的存储方式是数组，而非链表
 * @date 2021/5/19
 */
@Slf4j
public class BinaryHeapOperate {

    public static void main(String[] args) {
        // 构建堆
        int[] arr = {7, 1, 3, 10, 5, 2, 8, 9, 6};
        log.info("构建前:{}", Arrays.toString(arr));
        buildHeap(arr);
        log.info("构建完:{}", Arrays.toString(arr));
        // 插入堆
        arr = new int[]{1, 3, 2, 6, 5, 7, 8, 9, 10, 0};
        log.info("插入前:{}", Arrays.toString(arr));
        up(arr);
        log.info("插入后:{}", Arrays.toString(arr));
    }

    /**
     * 构建堆
     * 本质就是从最后一个非叶子节点下沉
     * @param arr
     */
    public static void buildHeap(int[] arr) {
        // 最后一个非叶子节点位置 (arr.length - 2) / 2 ； 并且前面的位置都是非叶子节点
        for (int i = (arr.length - 2) / 2 ; i >= 0; i--) {
            down(arr, i, arr.length);
        }
    }

    /**
     * 节点 上浮
     * 从最后一个节点开始上浮 （用于插入）
     *
     * @param arr
     */
    public static void up(int[] arr) {
        // 待比较的子节点位置
        int childIdx = arr.length - 1;
        // 待比较的父节点位置、
        int parIdx = (childIdx - 1) / 2;
        // 记录最初插入的值
        int insertVal = arr[childIdx];

        // 由insertVal来与 父节点比较，然后交换
        while (childIdx > 0 && insertVal < arr[parIdx]) {
            // 该步骤只是把父节点赋值给子节点， 相当于把父节点下沉
            arr[childIdx] = arr[parIdx];
            childIdx = parIdx;
            parIdx = (parIdx - 1) / 2;
        }

        // 遍历结束，赋值
        arr[childIdx] = insertVal;

    }

    /**
     * 非叶子节点  下沉
     * 与子节点对比，大于的话则替换
     * @param arr
     */
    public static void down(int[] arr, int parentIdx, int length) {
        // 记录需要下沉的节点值
        int downVal = arr[parentIdx];
        // 孩子位置 (默认初始值是 左节点)
        int childIdx = parentIdx * 2 + 1;

        while (childIdx < length) {
            // 比较左右俩子节点的大小
            if ((childIdx + 1) < length && arr[childIdx + 1] < arr[childIdx]) {
                childIdx ++;
            }
            // 如果父节点小于子节点，结束
            if (downVal <= arr[childIdx]) {
                break;
            }
            // 替换
            // 该步骤只是把子节点赋值给父节点， 相当于把子节点上浮
            arr[parentIdx] = arr[childIdx];
            parentIdx = childIdx;
            childIdx = childIdx * 2 + 1;
        }
        // 下沉结束，赋值
        arr[parentIdx] = downVal;
    }

}
