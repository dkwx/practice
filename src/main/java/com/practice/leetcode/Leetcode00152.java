package com.practice.leetcode;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00152 {


    class Solution {
        public int maxProduct(int[] nums) {
            int ans = nums[0];
            int max = nums[0], min = nums[0];
            for (int i = 1; i < nums.length; i++) {
                int v = nums[i];
                int currMax, currMin;
                if (v >= 0) {
                    currMax = Math.max(max * v, v);
                    currMin = Math.min(min * v, v);
                } else {
                    currMax = Math.max(min * v, v);
                    currMin = Math.min(max * v, v);
                }
                max = currMax;
                min = currMin;
                ans = Math.max(ans, max);
            }
            return ans;

        }
    }


    public static void main(String[] args) {
        Solution solution = new Leetcode00152().new Solution();
        System.out.println(solution.maxProduct(new int[]{-4, -3, -2}));
    }
}
