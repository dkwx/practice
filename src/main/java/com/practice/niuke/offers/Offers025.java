package com.practice.niuke.offers;

import com.practice.leetcode.assist.ListNode;

/**
 * 剑指offer
 *
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-27 13:34
 */
public class Offers025 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode result = new ListNode(-1);
            ListNode root = result;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    result.next = new ListNode(l2.val);
                    l2 = l2.next;
                    result = result.next;
                } else if (l2 == null) {
                    result.next = new ListNode(l1.val);
                    l1 = l1.next;
                    result = result.next;
                } else {
                    if (l1.val < l2.val) {
                        result.next = new ListNode(l1.val);
                        l1 = l1.next;
                        result = result.next;
                    } else {
                        result.next = new ListNode(l2.val);
                        l2 = l2.next;
                        result = result.next;
                    }
                }

            }
            return root.next;

        }
    }

    public static void main(String[] args) {
        System.out.println(new Offers025().new Solution().mergeTwoLists(null, null));
    }
}
