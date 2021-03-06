package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00560 {


    class Solution {
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> preSumMap = new HashMap<Integer, Integer>();
            int count = 0, sum = 0;
            preSumMap.put(0, 1);
            for (int num : nums) {
                sum += num;
                int target = sum - k;
                if (preSumMap.containsKey(target)) {
                    count += preSumMap.get(target);
                }
                preSumMap.put(sum, preSumMap.getOrDefault(sum, 0) + 1);
            }
            return count;

        }
        // 暴力法
        // public int subarraySum(int[] nums, int k) {
        //     int count = 0;
        //     for (int i = 0; i < nums.length; i++) {
        //         for (int j = nums.length - 1; j >= i; j--) {
        //             if (getSum(nums, i, j) == k) {
        //                 count++;
        //             }
        //         }
        //     }
        //     return count;
        // }
        //
        // public int getSum(int[] nums, int start, int end) {
        //     int sum = 0;
        //     for (int i = start; i <= end; i++) {
        //         sum += nums[i];
        //     }
        //     return sum;
        // }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00560().new Solution();
        System.out.println(solution.subarraySum(new int[]{1, 2}, 3));
    }
}
