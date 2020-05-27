package com.practice.niuke.offers;

import com.practice.leetcode.assist.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers007Wait {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        Map<Integer, Integer> intMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                intMap.put(inorder[i], i);
            }
            TreeNode root = findRootNode(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
            return root;
        }

        private TreeNode findRootNode(int[] preorder, int p1, int p2, int[] inorder, int i1, int i2) {
            if (p1 > p2 && i1 > i2) {
                return null;
            }
            int rootVal = preorder[p1];
            TreeNode result = new TreeNode(rootVal);
            int inOrderIndex = intMap.get(rootVal);
            int leftLength = inOrderIndex - i1;
            // int rightLength = i2 - inOrderIndex;
            result.left = findRootNode(preorder, p1 + 1, p1 + leftLength, inorder, i1, inOrderIndex - 1);
            result.right = findRootNode(preorder, p1 + leftLength + 1, p2, inorder, inOrderIndex + 1, i2);
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Offers007Wait().new Solution();
        //[3,9,20,15,7]
        // [9,3,15,20,7]
        TreeNode result = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(result.val);

    }
}
