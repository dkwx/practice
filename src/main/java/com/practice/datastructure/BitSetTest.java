package com.practice.datastructure;

import java.util.BitSet;
import java.util.stream.IntStream;

/**
 * @author : kai.dai
 * @date : 2020-05-23 17:38
 */
public class BitSetTest {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        IntStream.range(4, 10).forEach(i -> bitSet.set(i));
        IntStream.range(1, 10).forEach(i -> System.out.println(bitSet.get(i)));
    }
}
