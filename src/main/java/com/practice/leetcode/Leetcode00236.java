package com.practice.leetcode;

import com.practice.leetcode.assist.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * <p>百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * <p>例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1 输出: 3 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 *
 * <p>输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4 输出: 5 解释: 节点 5 和节点 4 的最近公共祖先是节点
 * 5。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * <p>说明:
 *
 * <p>所有节点的值都是唯一的。 p、q 为不同节点且均存在于给定的二叉树中。
 *
 * <p>来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00236 {

    class Solution {
        public TreeNode lowestCommonAncestor(
                TreeNode root, TreeNode p, TreeNode q) {
            Map<TreeNode, TreeNode> parentsMap = new HashMap<TreeNode, TreeNode>();

            read(null, root, parentsMap);
            Set<TreeNode> pParentSet = new HashSet<TreeNode>();
            TreeNode pParent = p;
            while (pParent != null) {
                pParentSet.add(pParent);
                pParent = parentsMap.get(pParent);
            }
            TreeNode qParent = q;
            while (null != qParent) {
                if (pParentSet.contains(qParent)) {
                    return qParent;
                }
                qParent = parentsMap.get(qParent);
            }
            return null;
        }

        private void read(TreeNode parent, TreeNode root, Map<TreeNode, TreeNode> parentsMap) {
            TreeNode left = root.left, right = root.right;
            parentsMap.put(root, parent);
            if (null != left) {
                read(root, left, parentsMap);
            }
            if (null != right) {
                read(root, right, parentsMap);
            }
        }


    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00236().new Solution();
        System.out.println(solution.lowestCommonAncestor(null, null, null));
    }
}
