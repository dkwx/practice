package com.practice.leetcode.temp;

/**
 * @author : kai.dai
 * @date : 2020-05-15 04:39
 */
public class Temp1 {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;

    }

    public static void main(String[] args) {

    }
}
