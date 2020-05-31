package com.practice.basic.base;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : kai.dai
 * @date : 2020-05-31 22:56
 */
public class ThreadLocalTest {
    static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    static SimpleDateFormat staticFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Calendar calendar = Calendar.getInstance();
        long sysTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int count = i;
            executorService.execute(() -> {
                Date date = new Date(sysTime + count*1000);
                // 并发问题
                // System.out.println(staticFormat.format(date));
                System.out.println(dateFormatThreadLocal.get().format(date));
            });

        }
        countDownLatch.await();
        executorService.shutdown();
    }
}
