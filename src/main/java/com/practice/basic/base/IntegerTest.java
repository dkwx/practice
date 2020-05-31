package com.practice.basic.base;

/**
 * @author : kai.dai
 * @date : 2020-05-30 20:40
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer i = 10;
        System.out.println(i);
        System.out.println(new Integer(10)==Integer.valueOf(10).intValue());
        System.out.println('\u0000');
        System.out.println('\u0001');
        System.out.println('\u0002');
        System.out.println('\u0003');
        System.out.println('\u0004');
        System.out.println('\u007f');
    }
}
