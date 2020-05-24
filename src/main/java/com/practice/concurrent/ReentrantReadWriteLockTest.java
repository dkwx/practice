package com.practice.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.IntStream;

/**
 * @author : kai.dai
 * @date : 2020-05-24 21:01
 */
public class ReentrantReadWriteLockTest {
    static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static void main(String[] args) throws Exception {
        new Thread(() -> {
            readWriteLock.readLock().lock();
            readWriteLock.writeLock().lock();
            try {
                System.out.println("获取到读锁");
            } finally {
                readWriteLock.writeLock().unlock();
                readWriteLock.readLock().unlock();
            }
        }).start();
        Thread.sleep(1000);
        System.out.println("结束");
    }

    private static void writeTest() {

        IntStream.range(1, 10).forEach((i) -> {
            new Thread(() -> {
                if (!readWriteLock.writeLock().tryLock()) {
                    System.out.println("没有获取到写锁");
                    return;
                }
                readWriteLock.writeLock().lock();
                try {
                    System.out.println("获取到写锁");
                } finally {
                    readWriteLock.writeLock().unlock();
                }
            }).start();
        });
    }

    private static void readTest() {
        IntStream.range(1, 10).forEach((i) -> {
            new Thread(() -> {
                if (!readWriteLock.readLock().tryLock()) {
                    System.out.println("没有获取到读锁");
                    return;
                }
                readWriteLock.readLock().lock();
                try {
                    System.out.println("获取到读锁");
                } finally {
                    readWriteLock.readLock().unlock();
                }
            }).start();
        });
    }
}
