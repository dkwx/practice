package com.practice.leetcode;

import com.practice.leetcode.assist.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00105 {


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
        Map<Integer, Integer> locationMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                locationMap.put(inorder[i], i);
            }
            return myBuild(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode myBuild(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
            if (pStart > pEnd) {
                return null;
            }
            int rootVal = preorder[pStart];
            int rootIndex = locationMap.get(rootVal);
            int leftSize = rootIndex - iStart;
            TreeNode root = new TreeNode(rootVal);
            root.left = myBuild(preorder, pStart + 1, pStart + leftSize, inorder, iStart, rootIndex - 1);
            root.right = myBuild(preorder, pStart + leftSize + 1, pEnd, inorder, rootIndex + 1, iEnd);
            return root;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00105().new Solution();
        TreeNode treeNode = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }
}
