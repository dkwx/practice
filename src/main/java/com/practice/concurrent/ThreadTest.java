package com.practice.concurrent;

/**
 * @author : kai.dai
 * @date : 2020-06-11 16:51
 */
public class ThreadTest {
    public static void main(String[] args) {
        // Thread类中interrupt（）、interrupted（）和isInterrupted（）方法详解
        // 原文链接：https://blog.csdn.net/qq_39682377/article/details/81449451
        Thread myThread = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        });
        myThread.start();
        myThread.interrupt();
        myThread.stop();
        System.out.println(myThread.isInterrupted());
        System.out.println(Thread.interrupted());
    }
}
