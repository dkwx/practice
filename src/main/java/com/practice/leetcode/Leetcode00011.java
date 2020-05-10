package com.practice.leetcode;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i,
 * 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * <p>说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * <p>
 *
 * <p>图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * <p>
 *
 * <p>示例：
 *
 * <p>输入：[1,8,6,2,5,4,8,3,7] 输出：49
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00011 {

  class Solution {
    public int maxArea(int[] height) {
      int maxArea = 0, i = 0, j = height.length - 1;
      while (i != j) {
        int area = Math.min(height[i], height[j]) * (j - i);
        maxArea = Math.max(area, maxArea);
        int temp = height[i] - height[j];
        if (temp >= 0) {
          j = j - 1;
        } else {
          i = i + 1;
        }
      }
      return maxArea;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Leetcode00011().new Solution();
    System.out.println(solution.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
  }
}
