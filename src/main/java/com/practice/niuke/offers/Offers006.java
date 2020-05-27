package com.practice.niuke.offers;

import com.practice.leetcode.assist.ListNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 剑指offer
 *
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 *
 * 限制：
 *
 * 0 <= 链表长度 <= 10000
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers006 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public int[] reversePrint(ListNode head) {
            List<Integer> list = new ArrayList<>();
            reverse(head, list);
            return list.stream().mapToInt(Integer::valueOf).toArray();
        }

        private void reverse(ListNode head, List<Integer> list) {
            if (null == head) {
                return;
            }
            reverse(head.next, list);
            list.add(head.val);
        }
    }

    public static void main(String[] args) {

    }
}
