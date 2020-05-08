package com.practice.leetcode;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * <p>示例:
 *
 * <p>输入:
 *
 * <p>1 0 1 0 0 1 0 1 1 1 1 1 1 1 1 1 0 0 1 0
 *
 * <p>输出: 4
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00221 {

    class Solution {
        public int maximalSquare(char[][] matrix) {
            if (null == matrix || 0 == matrix.length) {
                return 0;
            }
            int[][] lengthArr = new int[matrix.length][matrix[0].length];
            int maxLength = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    int currLength = dp(i, j, lengthArr, matrix[i][j]);
                    lengthArr[i][j] = currLength;
                    if (maxLength < currLength) {
                        maxLength = currLength;
                    }
                }
            }
            return maxLength * maxLength;
        }

        private int dp(int i, int j, int[][] lengthArr, char curr) {
            if (curr == '0') {
                return 0;
            }
            if (i == 0 || j == 0) {
                return 1;
            }
            if (i == 0 && j == 0) {
                return 1;
            }
            return Math.min(Math.min(lengthArr[i - 1][j], lengthArr[i][j - 1]), lengthArr[i - 1][j - 1]) + 1;
        }


    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00221().new Solution();
        char arrs[][] = {{'1', '1'}};
        System.out.println(solution.maximalSquare(arrs));
    }
}
