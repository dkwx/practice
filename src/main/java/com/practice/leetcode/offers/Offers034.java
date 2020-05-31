package com.practice.leetcode.offers;

import com.practice.leetcode.assist.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指offer
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers034 {
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
        List<List<Integer>> result = new ArrayList<>();
        int target;

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            target = sum;
            // readAllNode(root);
            find(root, new ArrayList<>(), 0);
            return result;

        }

        private void readAllNode(TreeNode root) {
            if (null == root) {
                return;
            }
            find(root, new ArrayList<>(), 0);
            readAllNode(root.left);
            readAllNode(root.right);
        }

        private void find(TreeNode root, List<Integer> list, int currSum) {
            if (root == null) {
                return;
            }
            int sum = currSum + root.val;
            list.add(root.val);
            if (sum == target && null == root.left && null == root.right) {
                result.add(list);
                return;
            } else {
                find(root.left, new ArrayList<>(list), sum);
                find(root.right, new ArrayList<>(list), sum);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new Offers034().new Solution().pathSum(null,1));
    }
}
