package com.practice.leetcode.assist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : kai.dai
 * @date : 2020-05-10 14:44
 */
public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(3);
        TreeNode p11 = new TreeNode(5);
        TreeNode p12 = new TreeNode(1);
        TreeNode p21 = new TreeNode(6);
        TreeNode p22 = new TreeNode(2);
        TreeNode p23 = new TreeNode(0);
        TreeNode p24 = new TreeNode(8);
        TreeNode p31 = new TreeNode(7);
        TreeNode p32 = new TreeNode(4);
        p.left = p11;
        p.right = p12;

        p11.left = p21;
        p11.right = p22;
        p12.left = p23;
        p12.right = p24;

        p22.left = p31;
        p22.right = p32;


        List<TreeNode> list = new ArrayList<>();
        read(p, list);
        System.out.println(list);
    }

    private static void read(TreeNode p, List<TreeNode> list) {
        if (p == null) {
            return;
        }
        read(p.left, list);
        list.add(p);
        read(p.right, list);

    }
}
