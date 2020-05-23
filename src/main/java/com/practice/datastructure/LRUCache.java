package com.practice.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : kai.dai
 * @date : 2020-05-23 22:23
 */
public class LRUCache {
    CrossNode head, tail;
    int maxSize;
    Map<Integer, CrossNode> map;

    class CrossNode {
        int key;
        int value;
        CrossNode pre;
        CrossNode next;
    }


    public LRUCache(int capacity) {
        maxSize = capacity;
        map = new HashMap<>(capacity);
        head = new CrossNode();
        tail = new CrossNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            CrossNode node = map.get(key);
            moveToHead(node);
            return node.value;
        } else {
            return -1;
        }
    }

    private void addNode(CrossNode node) {
        node.next = head.next;
        node.pre = head;

        head.next.pre = node;
        head.next = node;
    }

    private void popTail() {
        CrossNode removeNode = tail.pre;
        map.remove(removeNode.key);
        tail.pre = removeNode.pre;
        removeNode.pre.next = tail;
    }

    private void moveToHead(CrossNode node) {
        removeCrossNode(node);
        addNode(node);
    }

    public void removeCrossNode(CrossNode node) {
        CrossNode nowPre = node.pre;
        CrossNode nowNext = node.next;

        nowPre.next = nowNext;
        nowNext.pre = nowPre;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            CrossNode node = map.get(key);
            moveToHead(node);
            node.value = value;
        } else {
            CrossNode node = new CrossNode();
            node.key = key;
            node.value = value;
            addNode(node);
            map.put(node.key, node);
            if (map.size() > maxSize) {
                popTail();
            }
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);
        cache.put(3, 3);
        cache.get(2);
        cache.put(4, 4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }

}
