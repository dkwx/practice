package com.practice.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author : kai.dai
 * @date : 2020-05-25 18:51
 */
public class JvmTest {
    long flag;
    // Mark Word
    // class metadata address

    public static void main(String[] args) {
        JvmTest l = new JvmTest();
        System.out.println(l.hashCode());
        // LayOut
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
    }
}
