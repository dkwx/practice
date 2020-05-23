package com.practice.datastructure;

import java.util.PriorityQueue;

/**
 * @author : kai.dai
 * @date : 2020-05-23 16:20
 */
public class PriorityQueueTest {
    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(4);
        priorityQueue.add(5);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
