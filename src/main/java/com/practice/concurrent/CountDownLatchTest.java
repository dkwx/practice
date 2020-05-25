package com.practice.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author : kai.dai
 * @date : 2020-05-25 00:09
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(() -> {
            countDownLatch.countDown();
        }).start();
        new Thread(() -> {
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获取到锁1");
        }).start();
        new Thread(() -> {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("获取到锁2");
        }).start();
        Thread.sleep(1000);
        System.out.println("结束");

    }
}
