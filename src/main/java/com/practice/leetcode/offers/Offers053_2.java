package com.practice.leetcode.offers;

/**
 * 剑指offer
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers053_2 {
    class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int start = 0;
            int end = n - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int value = nums[mid];
                if (value == mid) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return start;
        }
    }

    public static void main(String[] args) {
        Offers053_2 offers = new Offers053_2();
        System.out.println(offers.new Solution().missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }
}
