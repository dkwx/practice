package com.practice.leetcode.assist;

import lombok.Data;

/**
 * @author : kai.dai
 * @date : 2020-05-25 23:19
 */
@Data
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }
}
