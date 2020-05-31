package com.practice.leetcode.offers;

import com.practice.leetcode.assist.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉树中。
 * 注意：本题与主站 236 题相同：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 剑指offer
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers068 {
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
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 把所有节点读到Map里
            readAllNode(root, null);

            Set<TreeNode> pParentSet = new HashSet<>();
            TreeNode temp = p;
            while (temp != null) {
                pParentSet.add(temp);
                TreeNode parent = parentMap.get(temp);
                if (null == parent) {
                    break;
                }
                temp = parent;
            }


            temp = q;
            while (temp != null) {
                if (pParentSet.contains(temp)) {
                    return temp;
                }
                temp = parentMap.get(temp);
            }
            return null;

        }

        private void readAllNode(TreeNode root, TreeNode parent) {
            if (null == root) {
                return;
            }
            parentMap.put(root, parent);
            readAllNode(root.left, root);
            readAllNode(root.right, root);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Offers999().new Solution().fib(2));
    }
}
