package com.practice.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author : kai.dai
 * @date : 2020-05-23 23:26
 */
public class TestCountDownLatch {
    CountDownLatch countDownLatch2 = new CountDownLatch(2);
    CountDownLatch countDownLatch1 = new CountDownLatch(1);

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatch2.countDown();
        countDownLatch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
