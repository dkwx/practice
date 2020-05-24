package com.practice.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : kai.dai
 * @date : 2020-05-24 20:40
 */
public class ReentrantLockTest {
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            reentrantLock.lock();
            reentrantLock.lock();
            try {
                System.out.println("获取到锁1");
            } finally {
                reentrantLock.unlock();
            }
        }).start();
        Thread.sleep(1000);
        new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("获取到锁2");
            } finally {
                reentrantLock.unlock();
            }
        }).start();
        Thread.sleep(1000);

    }
}
