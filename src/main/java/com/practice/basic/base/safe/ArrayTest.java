package com.practice.basic.base.safe;

import java.util.Arrays;

/**
 * @author : kai.dai
 * @date : 2020-06-04 11:25
 */
public class ArrayTest {
    public static void main(String[] args) {
        String a = null;

        arrayTest();
        arrayTest(null);
        arrayTest(a);
    }

    public static void arrayTest(String... strs) {
        System.out.println(Arrays.toString(strs));
    }
}
