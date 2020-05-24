package com.practice.concurrent;

import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

/**
 * @author : kai.dai
 * @date : 2020-05-24 20:40
 */
public class ReentrantLockTest {
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        IntStream.range(1, 10).forEach((i) -> {
            new Thread(() -> {
                if (!reentrantLock.tryLock()) {
                    System.out.println("没有获取到锁");
                    return;
                }
                reentrantLock.lock();
                try {
                    System.out.println("获取锁");
                } finally {
                    reentrantLock.unlock();
                }
            }).start();
        });

    }
}
