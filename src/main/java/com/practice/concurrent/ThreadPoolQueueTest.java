package com.practice.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : kai.dai
 * @date : 2020-06-17 20:26
 */
public class ThreadPoolQueueTest {
    public static void main(String[] args) throws InterruptedException {

        // ExecutorService executorService =  new ThreadPoolExecutor(2, 11,
        //         10L, TimeUnit.SECONDS,
        //         new LinkedBlockingQueue<Runnable>(3));
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // ExecutorService executorService = Executors.newCachedThreadPool();
        // ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(100);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for(int i = 0 ;i < 100 ;i ++){
            executorService.execute(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(atomicInteger.getAndIncrement());
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }
}
