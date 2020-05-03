package com.practice.leetcode;

import lombok.Data;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00002 {


    class Solution {
        /**
         *
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int left = l1 != null ? l1.val : 0;
            int right = l2 != null ? l2.val : 0;
            boolean flag = false;
            int sum = left + right;
            if (flag) {
                sum++;
                flag = false;
            }
            if (sum >= 10) {
                sum = sum % 10;
                flag = true;
            }
            ListNode head = new ListNode(sum);
            ListNode result = head;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;


            while (l1 != null || l2 != null || flag) {
                head.next = new ListNode(0);
                head = head.next;
                left = l1 != null ? l1.val : 0;
                right = l2 != null ? l2.val : 0;

                sum = left + right;
                if (flag) {
                    sum++;
                    flag = false;
                }
                if (sum >= 10) {
                    sum = sum % 10;
                    flag = true;
                }
                head.val = sum;
                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
            }
            return result;
        }

        public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);
            int left, right, sum;
            boolean flag = false;
            ListNode result = head;
            while (l1 != null || l2 != null || flag) {
                head.next = new ListNode(0);
                head = head.next;
                left = l1 != null ? l1.val : 0;
                right = l2 != null ? l2.val : 0;

                sum = left + right;
                if (flag) {
                    sum++;
                    flag = false;
                }
                if (sum >= 10) {
                    sum = sum % 10;
                    flag = true;
                }
                head.val = sum;
                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
            }
            return result.next;
        }

        @Data
        public class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00002().new Solution();
        Solution.ListNode listNodeL1 = solution.new ListNode(2);
        Solution.ListNode listNodeL2 = solution.new ListNode(4);
        Solution.ListNode listNodeL3 = solution.new ListNode(3);
        listNodeL1.next = listNodeL2;
        listNodeL2.next = listNodeL3;


        Solution.ListNode listNodeR1 = solution.new ListNode(5);
        Solution.ListNode listNodeR2 = solution.new ListNode(6);
        Solution.ListNode listNodeR3 = solution.new ListNode(4);
        listNodeR1.next = listNodeR2;
        listNodeR2.next = listNodeR3;
        System.out.println(solution.addTwoNumbers2(listNodeL1, listNodeR1));
    }
}
