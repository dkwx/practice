package com.practice.niuke.offers;

import com.practice.leetcode.assist.TreeNode;

/**
 * 剑指offer
 *
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 *  
 *
 * 限制：
 *
 * 1 ≤ k ≤ 二叉搜索树元素个数
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers054 {
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
        int number;
        int count = 0;
        int result;

        public int kthLargest(TreeNode root, int k) {
            number = k;
            //     右根左，中序遍历的倒序
            midOrderRead(root);
            return result;
        }

        private void midOrderRead(TreeNode root) {
            if (null == root) {
                return;
            }
            midOrderRead(root.right);
            count++;
            if (count == number) {
                result = root.val;
                return;
            }
            midOrderRead(root.left);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Offers054().new Solution().kthLargest(null,1));
    }
}
