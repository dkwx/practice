package com.practice.leetcode;

/**
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
 * s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * 给定的树 t：
 *
 * 4
 * / \
 * 1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 * 3
 * / \
 * 4   5
 * / \
 * 1   2
 * /
 * 0
 * 给定的树 t：
 *
 * 4
 * / \
 * 1   2
 * 返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00572 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (null == s) {
                return false;
            }
            return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        public boolean isSameTree(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            }
            if (s != null && t != null) {
                return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
            } else {
                return false;
            }

        }
    }

    public static void main(String[] args) {
        // Solution solution = new Leetcode00572().new Solution();
        // System.out.println(solution.isSubtree(new int[]{1, 2}));
    }
}
