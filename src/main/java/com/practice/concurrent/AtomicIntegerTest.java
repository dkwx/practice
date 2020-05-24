package com.practice.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author : kai.dai
 * @date : 2020-05-24 15:51
 */
public class AtomicIntegerTest {
    AtomicInteger atomicInteger = new AtomicInteger(1);
    CountDownLatch countDownLatch = new CountDownLatch(10);
    int count = 1;

    public static void main(String[] args) throws InterruptedException {
        AtomicIntegerTest atomicIntegerTest = new AtomicIntegerTest();
        IntStream.range(0, 10).forEach((i) -> {
            new Thread(() -> {
                for (int count = 0; count < 100000; count++) {
                    System.out.println(atomicIntegerTest.atomicInteger.getAndIncrement());
                    System.out.println("________测试" + atomicIntegerTest.count++);
                }
                atomicIntegerTest.countDownLatch.countDown();
            }).start();
        });
        atomicIntegerTest.countDownLatch.await();
        System.out.println("结束");
    }
}
