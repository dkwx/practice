package com.practice.leetcode;

import com.practice.leetcode.assist.ListNode;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 *  
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author : kai.dai
 * @date : 2020-05-03 21:18
 */
public class Leetcode00024 {


    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode result = new ListNode(-1);
            ListNode currentNode = head;
            while (currentNode != null) {
                // 获取下一个元素
                ListNode next = currentNode.getNext();
                // 将当前元素的下一个节点设置为结果的所有尾部
                currentNode.setNext(result.getNext());
                // 头插法
                result.setNext(currentNode);
                // 继续循环
                currentNode = next;
            }
            return result.next;
        }

        public ListNode reverseList2(ListNode head) {
            ListNode result = new ListNode(-1);
            ListNode currentNode = head;
            while (currentNode != null) {
                // 获取下一个元素
                ListNode next = currentNode.next;
                // 将当前元素的下一个节点设置为结果的所有尾部
                currentNode.next = result.next;
                // 头插法
                result.next = currentNode;
                // 继续循环
                currentNode = next;
            }
            return result.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Leetcode00024().new Solution();
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        head1.next = head2;
        head2.next = head3;
        ListNode node = solution.reverseList2(head1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
