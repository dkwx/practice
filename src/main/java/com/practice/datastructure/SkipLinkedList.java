package com.practice.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 跳表
 *
 * @author : kai.dai
 * @date : 2020-06-10 22:29
 */
public class SkipLinkedList {

    static class Node<V> {
        V val;
        Long score;
        Node next, down;

        public Node(long score, V value) {
            this.val = value;
            this.score = score;
        }
    }

    static class SkipLinked<V> {
        Node<V> head;
        int maxLevel;
        int length = 0;
        Random random = new Random();

        public SkipLinked(int level) {
            Node<V> temp = null;
            Node<V> pre = null;
            maxLevel = level;
            for (int i = 0; i < level; i++) {
                temp = new Node<>(Long.MAX_VALUE, null);
                temp.down = pre;
                pre = temp;
            }
            head = temp;
        }

        public void put(V key, long score) {
            Node<V> temp = head;
            List<Node<V>> pathList = new ArrayList<>();
            while (temp != null) {
                if (temp.score == score) {
                    break;
                }

                if (temp.next == null) {
                    pathList.add(temp);
                    temp = temp.down;
                    continue;
                }

                if (temp.next.score > score) {
                    pathList.add(temp);
                    temp = temp.down;
                    continue;
                } else {
                    temp = temp.next;
                }
            }
            if (temp != null) {
                temp.val = key;
            } else {
                int curLevel = random.nextInt(maxLevel) + 1;
                Node up = null;
                for (int i = 0; i < curLevel; i++) {
                    Node node = new Node(score, key);
                    Node pre = pathList.get(maxLevel - i - 1);
                    node.next = pre.next;
                    pre.next = node;
                    node.down = up;
                    up = node;
                }
                length++;
            }


        }

        public V get(long score) {
            Node<V> temp = head;
            while (temp != null) {
                if (temp.score == score) {
                    break;
                }

                if (temp.next == null) {
                    temp = temp.down;
                    continue;
                }

                if (temp.next.score > score) {
                    temp = temp.down;
                    continue;
                } else {
                    temp = temp.next;
                }
            }
            return temp == null ? null : temp.val;
        }

    }

    public static void main(String[] args) {
        SkipLinked<String> mySkip = new SkipLinked<String>(4);
        mySkip.put("a", 1);
        mySkip.put("c", 3);
        mySkip.put("b", 2);
        System.out.println(mySkip.get(2));
        System.out.println(mySkip.get(4));
    }
}
