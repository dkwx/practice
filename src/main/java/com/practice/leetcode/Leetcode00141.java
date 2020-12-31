package com.practice.leetcode;

import com.practice.leetcode.assist.ListNode;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是
 * -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 * <p>
 *  
 * <p>
 * 进阶：
 * <p>
 * 你能用 O(1)（即，常量）内存解决此问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00141 {


    class Solution {
        /**
         * Definition for singly-linked list.
         * class ListNode {
         * int val;
         * ListNode next;
         * ListNode(int x) {
         * val = x;
         * next = null;
         * }
         * }
         */
        public boolean hasCycle(ListNode head) {
            ListNode quick = head;
            ListNode slow = head;
            while (slow != null && quick != null) {
                if (quick.next == null) {
                    return false;
                }
                if (quick.next == slow) {
                    return true;
                }
                slow = slow.next;
                quick = quick.next.next;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;
        Solution solution = new Leetcode00141().new Solution();
        System.out.println(solution.hasCycle(node1));
    }
}
