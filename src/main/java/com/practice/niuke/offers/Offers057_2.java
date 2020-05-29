package com.practice.niuke.offers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指offer
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers057_2 {
    class Solution {
        public int[][] findContinuousSequence(int target) {
            int mid = (target + 1) / 2;
            int left = 1, right = 1;
            int sum = 0;
            List<int[]> result = new ArrayList<>();
            while (left <= mid) {

                if (sum > target) {
                    sum -= left;
                    left++;
                } else if (sum < target) {
                    sum += right;
                    right++;
                } else {
                    //     记录
                    int[] arrs = new int[right - left];
                    int count = 0;
                    for (int i = left; i < right; i++) {
                        arrs[count] = i;
                        count++;
                    }
                    result.add(arrs);
                    // 左边界向右移动
                    sum -= left;
                    left++;
                }
            }
            return result.toArray(new int[0][0]);
        }

    }

    public static void main(String[] args) {
        int[][] arrs = new Offers057_2().new Solution().findContinuousSequence(9);
        System.out.println(Arrays.toString(arrs));
    }
}
