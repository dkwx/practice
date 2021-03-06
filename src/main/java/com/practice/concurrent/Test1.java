package com.practice.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 拦截器
 * @author : kai.dai
 * @date : 2020-05-23 11:26
 */
public class Test1 {
    public class Counter {
        /**
         * 最大访问数量
         */
        private final int limit = 10;
        /**
         * 访问时间差
         */
        private final long timeout = 1000;
        /**
         * 请求时间
         */
        private long time;
        /**
         * 当前计数器
         */
        private AtomicInteger reqCount = new AtomicInteger(0);

        public boolean limit() {
            long now = System.currentTimeMillis();
            if (now < time + timeout) {
                // 单位时间内
                reqCount.addAndGet(1);
                return reqCount.get() <= limit;
            } else {
                // 超出单位时间
                time = now;
                reqCount = new AtomicInteger(0);
                return true;
            }
        }
    }
}
