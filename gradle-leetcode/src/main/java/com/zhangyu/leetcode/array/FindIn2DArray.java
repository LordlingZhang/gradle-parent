package com.zhangyu.leetcode.array;

/**
 * @author zhangyu
 * @description: 二维数组中的查找
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 * Input:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Output:
 * 15->true  ,  20->false
 * <p>
 * https://github.com/CyC2018/CS-Notes/blob/master/notes/4
 * .%20%E4%BA%8C%E7%BB%B4%E6%95%B0%E7%BB%84%E4%B8%AD%E7%9A%84%E6%9F%A5%E6%89%BE.md
 * @date 2021/6/23
 */
public class FindIn2DArray {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumber(arr, 20));
    }

    /**
     * 本题的解题思路： 任意一个位置，左边的肯定比他小，下面的肯定比他大
     * 所以选择从右上角开始 操作， 太小的话直接 到下一行，太大了就往左
     * <p>
     * 时间复杂度 O(M + N)，空间复杂度 O(1)。其中 M 为行数，N 为 列数。
     *
     * @param arr
     * @return
     */
    public static boolean findNumber(int[][] arr, int findX) {
        int rows = arr.length, cols = arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = cols - 1; j >= 0; j--) {
                if (findX == arr[i][j]) {
                    return true;
                } else if (findX > arr[i][j]) {
                    // 跳到下一行
                    break;
                } else {
                    // 往左移动一个
                    continue;
                }
            }
        }
        return false;
    }

}
