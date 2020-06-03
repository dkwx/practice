package com.practice.basic.base.lock;

/**
 * @author : kai.dai
 * @date : 2020-06-03 01:03
 */
public class DeadLock {
    static Object dkLock1 = new Object();
    static Object dkLock2 = new Object();

    public static void main(String[] args) {
       Thread t1 =  new Thread(
                () -> {
                    synchronized (dkLock1) {
                        try {
                            System.out.println("线程1拿到a锁");
                            Thread.sleep(1000);
                            synchronized (dkLock2) {
                                System.out.println("线程1拿到b锁");
                                System.out.println("线程1拿到b锁");

                            }
                            System.out.println("线程1释放a锁");

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                });
        Thread t2 = new Thread(
                () -> {
                    synchronized (dkLock2) {
                        try {
                            System.out.println("线程2拿到b锁");
                            Thread.sleep(1000);
                            synchronized (dkLock1) {
                                System.out.println("线程2拿到a锁");
                                System.out.println("线程2拿到a锁");

                            }
                            System.out.println("线程2释放b锁");

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                });
        t1.setName("daikaiThread1");
        t2.setName("daikaiThread2");
        t1.start();
        t2.start();
    }
}
