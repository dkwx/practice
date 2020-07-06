package com.practice.leetcode;

import com.practice.leetcode.assist.TreeNode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
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
 *
 * 提示：
 *
 * 节点总数 <= 1000
 * 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00032_2 {


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


        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            if (null == root) {
                return list;
            }
            List<TreeNode> pre = new ArrayList<>();
            List<Integer> cur;
            pre.add(root);
            while (!pre.isEmpty()) {
                List<TreeNode> newPre = new ArrayList<>();
                cur = new ArrayList<>();
                for (TreeNode node : pre) {
                    cur.add(node.val);
                    if (null != node.left) {
                        newPre.add(node.left);
                    }
                    if (null != node.right) {
                        newPre.add(node.right);
                    }
                }
                pre = newPre;
                list.add(cur);
            }

            return list;
        }

    }

    private static final long START_SALE_TIME = 2500 * 60 * 60L;
    private static final long END_SALE_TIME = (27 * 24 + 1) * 60 * 60 * 1000L;

    public static void main(String[] args) {
        // Solution solution = new Leetcode00032_2().new Solution();
        // System.out.println(solution.levelOrder(null));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse("202007190432");
            long interval = date.getTime() - System.currentTimeMillis();
            // 时间校验
            if (interval < START_SALE_TIME || interval >= END_SALE_TIME) {
                System.out.println("不符合");
            }
        } catch (ParseException var4) {
        }
    }
}
