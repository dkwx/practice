package com.practice.leetcode;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * 5
 * / \
 * 1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00098 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValid(root, null, null);
        }

        private boolean isValid(TreeNode root, Integer lower, Integer upper) {
            if (root == null) {
                return true;
            }
            if (null != lower && root.val <= lower) {
                return false;
            }
            if (null != upper && root.val >= upper) {
                return false;
            }
            return isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
        }


    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00098().new Solution();
        TreeNode root = new Leetcode00098().new TreeNode(1);
        TreeNode node1 = new Leetcode00098().new TreeNode(1);
        // TreeNode node2 = new Leetcode00098().new TreeNode(3);

        root.left = node1;
        // root.right = node2;

        System.out.println(solution.isValidBST(root));
    }
}
