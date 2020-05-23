package com.practice.datastructure;

import sun.jvm.hotspot.utilities.BitMap;

import java.util.stream.IntStream;

/**
 * @author : kai.dai
 * @date : 2020-05-23 17:23
 */
public class BitMapTest {
    public static void main(String[] args) {
        BitMap bitMap = new BitMap(10);
        IntStream.range(1, 4).forEach(i -> bitMap.atPut(i, true));
        System.out.println(bitMap.at(1));
        System.out.println(bitMap.at(5));
    }
}
