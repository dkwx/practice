package com.practice.leetcode;

import com.practice.leetcode.assist.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *  
 *
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 *
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00102 {


    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (null == root) {
                return new ArrayList<>();
            }
            List<TreeNode> preList = new ArrayList<>();
            preList.add(root);
            List<List<Integer>> result = new ArrayList<>();
            while (preList.size() > 0) {
                List<TreeNode> temp = new ArrayList<>();
                List<Integer> integers = new ArrayList<>();
                for (TreeNode node : preList) {
                    integers.add(node.val);
                    if (null != node.left) {
                        temp.add(node.left);
                    }
                    if (null != node.right) {
                        temp.add(node.right);
                    }
                }
                preList = temp;
                result.add(integers);
            }
            return result;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00102().new Solution();
        // System.out.println(solution.levelOrder(new int[]{1, 2}));
    }
}
