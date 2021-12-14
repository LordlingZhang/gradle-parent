package com.zhangyu.nowcoder;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @description: NC119 最小的K个数
 * https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=117&&tqId=37765&rp=1&ru=/activity/oj&qru=/ta/job-code-high/question-ranking
 * @date 2021/12/7
 */
@Slf4j
public class NC119SmallNums {

    public static void main(String[] args) {
        int[] a = {1,3,6,3,2,8,5};
        log.info("output:{}", GetLeastNumbers_Solution(a, 9));
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        List<Integer> out = new ArrayList<>();
        if (k == 0) {
            return (ArrayList<Integer>) out;
        }
        int l = 0,r = input.length - 1;
        // 使用快排获取基准位置
        while (l < r) {
            int jz = getJiZhunIdx(input, l, r);
            if (jz == k) {
                break;
            } else if (jz < k) {
                l = jz + 1;
            } else if (jz > k) {
                r = jz - 1;
            }
        }
         k = (k >input.length ? input.length : k);
        for (int i=0 ;i< k;i++) {
            out.add(input[i]);
        }
        return (ArrayList<Integer>) out;
    }

    /**
     * 利用快排的单边法获取基准位置
     * @param input
     * @param lIdx
     * @param rIdx
     * @return
     */
    public static int getJiZhunIdx(int[] input, int lIdx, int rIdx) {
        int jz = input[lIdx];
        // 定义基准的位置
        int mark = lIdx;

        for (int i = lIdx + 1; i<=rIdx; i++) {
            if (input[i] < jz) {
                mark ++;
                int t = input[i];
                input[i] = input[mark];
                input[mark] = t;
            }
        }
        // 交换mark和 初始基准的位置
        input[lIdx] = input[mark];
        input[mark] = jz;
        return mark;
    }
}
