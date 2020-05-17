package com.practice.leetcode;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00034 {


    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int targetStart = -1, targetEnd = -1;
            if (null == nums || nums.length == 0) {
                return new int[]{targetStart, targetEnd};
            }
            int start = 0, end = nums.length - 1;
            int localIndex = -1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] == target) {
                    localIndex = mid;
                    break;
                } else if (nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (localIndex != -1) {
                targetStart = localIndex;
                targetEnd = localIndex;
                while (targetStart > 0 && nums[targetStart - 1] == target) {
                    targetStart--;
                }
                while (targetEnd < (nums.length - 1) && nums[targetEnd + 1] == target) {
                    targetEnd++;
                }
            }
            return new int[]{targetStart, targetEnd};
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00034().new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[]{1, 2, 3, 3, 4}, 3)));
    }
}
