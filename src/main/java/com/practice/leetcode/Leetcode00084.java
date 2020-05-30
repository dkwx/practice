package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 *  
 *
 *
 *
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 *
 *  
 *
 *
 *
 * 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
 *
 *  
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3]
 * 输出: 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00084 {


    class Solution {
        public int largestRectangleArea(int[] heights) {
            int length = heights.length + 2;
            int[] arrs = new int[length];
            int max = 0;
            for (int i = 1; i < length - 1; i++) {
                arrs[i] = heights[i - 1];
            }
            Deque<Integer> deque = new ArrayDeque<>();
            deque.push(0);

            for (int i = 1; i < length; i++) {
                int value = arrs[i];
                while (arrs[deque.peek()] > value) {
                    int index = deque.pop();
                    int wide = i - deque.peek() - 1;
                    int hight = arrs[index];
                    int area = wide * hight;
                    max = Math.max(area, max);

                }
                deque.push(i);
            }
            return max;

        }
        // public int largestRectangleArea(int[] heights) {
        //     int max = 0;
        //     // 以当前位置最大面积
        //     for (int i = 0; i < heights.length; i++) {
        //         int length = heights[i];
        //         int wide = findWide(heights, i);
        //         int area = length * wide;
        //         if (area > max) {
        //             max = area;
        //         }
        //     }
        //     return max;
        //
        // }
        // 暴力法

        // private int findWide(int[] heights, int i) {
        //     int wide = 1;
        //     int left = i - 1, right = i + 1;
        //     int value = heights[i];
        //     while (left >= 0) {
        //         if (heights[left] >= value) {
        //             wide++;
        //             left--;
        //         } else {
        //             break;
        //         }
        //     }
        //     while (right <= (heights.length - 1)) {
        //         if (heights[right] >= value) {
        //             wide++;
        //             right++;
        //         } else {
        //             break;
        //         }
        //     }
        //     return wide;
        // }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00084().new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2, 1, 2}));
    }
}
