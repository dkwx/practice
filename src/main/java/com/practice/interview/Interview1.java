package com.practice.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 美团面试
 * 三个线程循环打印ABC指定次数
 *
 * @author : kai.dai
 * @date : 2020-05-25 09:46
 */
public class Interview1 {
    static char ch = 'A';
    static Lock lock = new ReentrantLock();
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();
    static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        new Thread(() -> printA(3)).start();
        new Thread(() -> printB(3)).start();
        new Thread(() -> printC(3)).start();
    }

    private static void printA(int count) {
        lock.lock();
        try {
            while (count > 0) {
                while (ch != 'A') {
                    try {
                        conditionA.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(ch);
                count--;
                ch = 'B';
                conditionB.signal();
            }
        } finally {
            lock.unlock();
        }

    }

    private static void printB(int count) {
        lock.lock();
        try {
            while (count > 0) {
                while (ch != 'B') {
                    try {
                        conditionB.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(ch);
                count--;
                ch = 'C';
                conditionC.signal();
            }
        } finally {
            lock.unlock();
        }

    }

    private static void printC(int count) {
        lock.lock();
        try {
            while (count > 0) {
                while (ch != 'C') {
                    try {
                        conditionC.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(ch);
                count--;
                ch = 'A';
                conditionA.signal();
            }
        } finally {
            lock.unlock();
        }

    }

}
