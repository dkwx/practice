package com.practice.leetcode.offers;

/**
 * 剑指offer
 *
 * 面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 *
 *
 * 示例 1：
 *
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 *
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 *
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers013 {
    class Solution {
        boolean[][] masks;

        public int movingCount(int m, int n, int k) {
            masks = new boolean[m][n];
            return movingCount(m, n, 0, 0, k);
        }

        public int movingCount(int m, int n, int i, int j, int k) {
            if (i >= m || j >= n || masks[i][j] == true) {
                return 0;
            }
            if (bigger(i, j, k)) {
                return 0;
            }
            masks[i][j] = true;
            return 1 + movingCount(m, n, i + 1, j, k) + movingCount(m, n, i, j + 1, k);

        }

        private boolean bigger(int i, int j, int k) {
            int sum = 0;
            while (i != 0) {
                sum += i % 10;
                i = i / 10;
            }
            while (j != 0) {
                sum += j % 10;
                j = j / 10;
            }
            return sum > k;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Offers013().new Solution();
        System.out.println(solution.movingCount(1,2,1));
    }
}
