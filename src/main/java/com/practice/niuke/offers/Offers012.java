package com.practice.niuke.offers;

/**
 * 剑指offer
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 *
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers012 {


    class Solution {
        boolean[][] marked;
        char[][] globalBoard;
        String target;
        int m, n;

        public boolean exist(char[][] board, String word) {
            m = board.length;
            n = board[0].length;
            globalBoard = board;
            target = word;
            marked = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isSuit(i, j, 0)) {
                        return true;
                    }
                }

            }
            return false;
        }

        private boolean isSuit(int i, int j, int start) {
            if (start == (target.length() - 1)) {
                return globalBoard[i][j] == target.charAt(start);
            }
            if (globalBoard[i][j] != target.charAt(start)) {
                return false;
            }
            marked[i][j] = true;
            //   继续向上
            int next = start + 1;
            if (i >= 1 && !marked[i - 1][j]) {
                if (isSuit(i - 1, j, next)) {
                    return true;
                }
            }
            //    继续向下
            if (i < (m - 1) && !marked[i + 1][j]) {
                if (isSuit(i + 1, j, next)) {
                    return true;
                }
            }
            //    继续向左
            if (j >= 1 && !marked[i][j - 1]) {
                if (isSuit(i, j - 1, next)) {
                    return true;
                }
            }
            //    继续向右
            if (j < (n - 1) && !marked[i][j + 1]) {
                if (isSuit(i, j + 1, next)) {
                    return true;
                }
            }
            marked[i][j] = false;
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Offers012().new Solution();
        char[][] chars = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        solution.exist(chars,"ABCCED");
    }
}
