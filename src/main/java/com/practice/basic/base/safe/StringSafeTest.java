package com.practice.basic.base.safe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author : kai.dai
 * @date : 2020-06-04 10:28
 */
public class StringSafeTest {
    static String testStr = "";
    static CountDownLatch countDownLatch = new CountDownLatch(1000);

    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 1000; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    countDownLatch.countDown();
                    append(1);
                }
            });
        }
        countDownLatch.await();
        System.out.println(testStr.length());

    }

    public static void append(int i) {
        testStr = testStr + i;
    }
}
