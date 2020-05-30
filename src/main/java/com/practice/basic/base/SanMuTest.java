package com.practice.basic.base;

/**
 * @author : kai.dai
 * @date : 2020-05-30 21:12
 */
public class SanMuTest {
    public static void main(String[] args) {
        // int a = 1, b = 10;
        // int temp1 = 0 < 1 ? a++ : b++;
        // System.out.println("a = " + a + ", b = " + b);
        // System.out.println("temp1 = " + temp1);
        // // a = 2, b = 10
        // // temp1 = 1

        // int c = 1, d = 10;
        // int temp2 = 0 < 1 ? c = c + 1 : d + 1;
        // System.out.println("c = " + c + ", d = " + d);
        // System.out.println("temp2 = " + temp2);
        // // c = 2, d = 10
        // // temp2 = 2

        int c = 1, d = 10;
        int temp2 = 0 > 1 ? c = c + 1 : d + 1;
        System.out.println("c = " + c + ", d = " + d);
        System.out.println("temp2 = " + temp2);

        char a = 'A';
        int i = 0;
        System.out.println((true ? a : 0) + "," + (false ? i : a));
        // A,65 他们两个要转换成相同的类型，且是转换成true所在位置变量的类型
    }
}
