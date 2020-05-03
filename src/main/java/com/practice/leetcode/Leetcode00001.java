package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00001 {
    class Solution {
        /**
         *
         */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> maps = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                int curr = nums[i];
                int temp = target - curr;
                Integer index = maps.get(temp);
                if (index != null) {
                    return new int[]{index, i};
                }
                maps.put(curr, i);
            }
            return null;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00001().new Solution();
        int[] nums = {2, 7, 11, 15};
        System.out.println(solution.twoSum(nums, 9));
    }
}
