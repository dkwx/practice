package com.practice.datastructure;

/**
 * 大顶堆
 *
 * @author : kai.dai
 * @date : 2020-05-23 15:47
 */
public class BigHeap {

    private int[] arrs = new int[256];

    public int size = 0;


    public void add(int v) {
        size++;
        int location = size - 1;
        arrs[location] = v;
        while (location > 0) {
            int parent = (location - 1) / 2;
            if (arrs[parent] < arrs[location]) {
                int temp = arrs[parent];
                arrs[parent] = arrs[location];
                arrs[location] = temp;
                location = parent;
            } else {
                break;
            }
        }
    }

    public int pop() {
        int result = arrs[0];
        int location = 0;
        arrs[0] = arrs[size - 1];
        size--;
        while (location < size) {
            int left = location * 2 + 1;
            int right = location * 2 + 1;
            if (arrs[left] <= arrs[location] && arrs[right] <= arrs[location]) {
                break;
            }
            if (arrs[left] > arrs[right]) {
                int temp = arrs[left];
                arrs[left] = arrs[location];
                arrs[location] = temp;
                location = left;
            } else {
                int temp = arrs[right];
                arrs[right] = arrs[location];
                arrs[location] = temp;
                location = right;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        BigHeap bigHeap = new BigHeap();
        bigHeap.add(1);
        bigHeap.add(2);
        bigHeap.add(3);
        bigHeap.add(4);
        bigHeap.add(5);
        while (bigHeap.size > 0) {
            System.out.println(bigHeap.pop());
        }
    }


}
