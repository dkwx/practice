package com.practice.leetcode;

import java.util.Arrays;

/**
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00088 {


    class Solution {
        // 从后往前，不需要额外空间
        public void merge1(int[] nums1, int m, int[] nums2, int n) {
            int length = m + n;
            int index1 = m - 1, index2 = n - 1;
            for (int i = length - 1; i >= 0; i--) {
                if (index1 < 0) {
                    nums1[i] = nums2[index2];
                    index2--;
                } else if (index2 < 0) {
                    nums1[i] = nums1[index1];
                    index1--;
                } else {
                    int v1 = nums1[index1];
                    int v2 = nums2[index2];
                    if (v1 > v2) {
                        nums1[i] = v1;
                        index1--;
                    } else {
                        nums1[i] = v2;
                        index2--;
                    }
                }
            }
        }

        // method1 从前往后需要额外空间
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] arr1 = Arrays.copyOf(nums1, m);
            int[] arr2 = Arrays.copyOf(nums2, n);
            int length = m + n;
            int index1 = 0, index2 = 0;
            for (int i = 0; i < length; i++) {
                if (index1 >= m) {
                    nums1[i] = arr2[index2];
                    index2++;
                    continue;
                }
                if (index2 >= n) {
                    nums1[i] = arr1[index1];
                    index1++;
                    continue;
                }
                int v1 = arr1[index1];
                int v2 = arr2[index2];
                if (v1 > v2) {
                    nums1[i] = v2;
                    index2++;
                } else {
                    nums1[i] = v1;
                    index1++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00088().new Solution();
        solution.merge1(new int[]{1, 2, 0, 0}, 2, new int[]{1, 2}, 2);
    }
}
