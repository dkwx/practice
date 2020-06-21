package com.practice.leetcode.offers;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers053_1 {
    class Solution {
        public int search(int[] nums, int target) {
            int index = findIndex(nums, target);
            if (index < 0) {
                return 0;
            }
            int count = 1;
            int i = index - 1;
            while (i >= 0) {
                if (nums[i] == target) {
                    count++;
                    i--;
                } else {
                    break;
                }
            }
            i = index + 1;
            while (i < nums.length) {
                if (nums[i] == target) {
                    count++;
                    i++;
                } else {
                    break;
                }
            }
            return count;

        }

        public int findIndex(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int value = nums[mid];
                if (value == target) {
                    return mid;
                } else if (value > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return -1;

        }
    }

    public static void main(String[] args) {
        Offers053_1 offers = new Offers053_1();
        System.out.println(offers.new Solution().search(new int[]{1, 2, 3, 4, 5, 9}, 4));
    }
}
