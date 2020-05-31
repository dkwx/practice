package com.practice.leetcode.offers;

/**
 * 剑指offer
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *  
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers029 {
    class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (null == matrix || matrix.length == 0) {
                return new int[0];
            }
            int left = 0;
            int right = matrix[0].length - 1;
            int up = 0;
            int down = matrix.length - 1;
            int[] result = new int[matrix.length * matrix[0].length];
            int index = 0;
            while (true) {
                // 左到右
                for (int i = left; i <= right; i++) {
                    result[index] = matrix[up][i];
                    index++;
                }
                up++;
                if (up > down) {
                    break;
                }
                // 从上到下
                for (int i = up; i <= down; i++) {
                    result[index] = matrix[i][right];
                    index++;
                }
                right--;
                if (left > right) {
                    break;
                }
                // 从右到左
                for (int i = right; i >= left; i--) {
                    result[index] = matrix[down][i];
                    index++;
                }
                down--;
                if (up > down) {
                    break;
                }
                //   从下到上
                for (int i = down; i >= up; i--) {
                    result[index] = matrix[i][left];
                    index++;
                }
                left++;
                if (left > right) {
                    break;
                }
            }
            return result;

        }
    }

    public static void main(String[] args) {
        int[][] arrs = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new Offers029().new Solution().spiralOrder(arrs));
    }
}
