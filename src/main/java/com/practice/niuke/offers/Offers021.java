package com.practice.niuke.offers;

/**
 * 剑指offer
 *输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers021 {
    class Solution {
        public int[] exchange(int[] nums) {
            int length = nums.length;
            int p = 0, q = length - 1;
            while (p < q) {
                // 从前往后找第一个偶数
                while (p < q && isQiShu(nums[p])) {
                    p++;
                }

                // 从后往前找第一个奇数
                while (p < q && !isQiShu(nums[q])) {
                    q--;
                }
                int temp = nums[p];
                nums[p] = nums[q];
                nums[q] = temp;
            }
            return nums;
        }

        // public int[] exchange(int[] nums) {
        //     int[] result = new int[nums.length];
        //     int start = 0, end = nums.length - 1;
        //     // 找偶数和后面的奇数
        //     for (int i = 0; i < nums.length; i++) {
        //         if (isQiShu(nums[i])) {
        //             result[start++] = nums[i];
        //         } else {
        //             result[end--] = nums[i];
        //         }
        //     }
        //     return result;
        // }
        //
        public boolean isQiShu(int num) {
            return (num & 1) > 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Offers021().new Solution().exchange(null));
    }
}
