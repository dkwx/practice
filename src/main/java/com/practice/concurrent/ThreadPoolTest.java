package com.practice.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : kai.dai
 * @date : 2020-06-11 15:52
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        // 单个线程
        // new ThreadPoolExecutor(1, 1,
        //         0L, TimeUnit.MILLISECONDS,
        //         new LinkedBlockingQueue<Runnable>());
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // new ThreadPoolExecutor(nThreads, nThreads,
        //         0L, TimeUnit.MILLISECONDS,
        //         new LinkedBlockingQueue<Runnable>());
        executorService = Executors.newFixedThreadPool(5);
        // new ThreadPoolExecutor(0, Integer.MAX_VALUE,
        //         60L, TimeUnit.SECONDS,
        //         new SynchronousQueue<Runnable>())
        executorService = Executors.newCachedThreadPool();
        System.out.println(executorService);
    }
}
