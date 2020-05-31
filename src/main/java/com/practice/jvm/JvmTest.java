package com.practice.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author : kai.dai
 * @date : 2020-05-25 18:51
 */
public class JvmTest {
    long l;
    boolean flag;
    boolean flag2;
    // boolean[] flags1=new boolean[1];
    // boolean[] flags4=new boolean[4];
    // boolean[] flags5=new boolean[5];
    // boolean[] flags32=new boolean[32];
    // boolean[] flags33=new boolean[33];
    // boolean[] flags64=new boolean[64];
    // boolean[] flags65=new boolean[65];

    // Mark Word
    // class metadata address

    public static void main(String[] args) {
        JvmTest l = new JvmTest();
        // System.out.println(Integer.toHexString(l.hashCode()));
        System.out.println("无锁");
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
        synchronized (l){
            System.out.println("锁1");
            System.out.println(ClassLayout.parseInstance(l).toPrintable());
        }
        new Thread(()->{
            synchronized (l){
                System.out.println("并发锁1");
                System.out.println(ClassLayout.parseInstance(l).toPrintable());
            }
        }).start();
        synchronized (l){
            System.out.println("锁2");
            System.out.println(ClassLayout.parseInstance(l).toPrintable());
        }


        // LayOut
        System.out.println("解锁");
        System.out.println(ClassLayout.parseInstance(l).toPrintable());
    }
}
