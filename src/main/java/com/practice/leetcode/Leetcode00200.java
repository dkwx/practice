package com.practice.leetcode;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00200 {


    class Solution {
        public int numIslands(char[][] grid) {
            int sum = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        sum++;
                        deepSearch(grid, i, j);
                    }
                }

            }
            return sum;
        }

        private void deepSearch(char[][] grid, int i, int j) {
            if (grid[i][j] == '1') {
                grid[i][j] = '0';
                if (i > 0) {
                    deepSearch(grid, i - 1, j);
                }
                if (i < (grid.length - 1)) {
                    deepSearch(grid, i + 1, j);
                }
                if (j > 0) {
                    deepSearch(grid, i, j - 1);
                }
                if (j < (grid[0].length - 1)) {
                    deepSearch(grid, i, j + 1);
                }
            }

        }

    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00200().new Solution();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(solution.numIslands(grid));
    }
}
