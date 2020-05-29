package com.practice.leetcode;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00198 {


    class Solution {
        // dp[i]=max(dp[i−2]+nums[i],dp[i−1])
        public int rob(int[] nums) {
            if (null == nums || nums.length == 0) {
                return 0;
            }
            int length = nums.length;
            if (length == 1) {
                return nums[0];
            }
            if (length == 2) {
                return Math.max(nums[0], nums[1]);
            }
            int[] dpArray = new int[length];
            dpArray[0] = nums[0];
            dpArray[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < length; i++) {
                dpArray[i] = Math.max(dpArray[i - 1], dpArray[i - 2] + nums[i]);
            }
            return dpArray[length - 1];

        }
        // 栈溢出
        // private int getDp(int i) {
        //     if (i == 0) {
        //         return allData[0];
        //     }
        //     if (i == 1) {
        //         return Math.max(allData[0], allData[1]);
        //     }
        //     return Math.max(getDp(i - 1), getDp(i - 2) + allData[i]);
        // }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00198().new Solution();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
    }
}
