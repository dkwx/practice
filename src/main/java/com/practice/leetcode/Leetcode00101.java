package com.practice.leetcode;

import com.practice.leetcode.assist.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00101 {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (null == root) {
                return true;
            }
            // return isLeftRight(root.left, root.right);
            return check(root, root);
        }

        private boolean check(TreeNode left, TreeNode right) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(left);
            queue.offer(right);
            while (!queue.isEmpty()) {
                TreeNode p = queue.poll();
                TreeNode q = queue.poll();
                if (p == null && q == null) {
                    continue;
                }

                if (p == null || q == null || p.val != q.val) {
                    return false;
                }

                queue.offer(p.left);
                queue.offer(q.right);

                queue.offer(p.right);
                queue.offer(q.left);

            }
            return true;

        }

        private boolean isLeftRight(TreeNode left, TreeNode right) {
            if (left == right) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            return isLeftRight(left.left, right.right) && isLeftRight(left.right, right.left);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00101().new Solution();
        System.out.println(solution.isSymmetric(null));
    }
}
