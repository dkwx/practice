package com.practice.concurrent;

/**
 * @author : kai.dai
 * @date : 2020-05-23 23:26
 */
public class TestWait {
    public static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {


        new Thread(() -> {
            synchronized (lock) {
                System.out.println("线程2运行");
                lock.notify();
                System.out.println("线程2释放锁0");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程2释放锁1");
            }
            System.out.println("线程2释放锁2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程2释放锁3");

        }).start();
        new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("线程1获取锁等待");
                    lock.wait();
                    System.out.println("线程1执行结果");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
        Thread.sleep(1000);
    }

}
