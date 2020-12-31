package com.practice.framework.bufferTrigger;

import java.util.List;
import java.util.concurrent.TimeUnit;

import com.github.phantomthief.collection.BufferTrigger;

/**
 * @author daikai <daikai@kuaishou.com>
 * Created on 2020-12-29
 */
public class BufferTriggerTest {
    private BufferTrigger<String> bufferTrigger =
            BufferTrigger.<String> batchBlocking() //
                    .setConsumerEx(strings -> soutStrs(strings))
                    .batchSize(200) // 每200个归并一次
                    .linger(500, TimeUnit.MILLISECONDS) // 每隔500毫秒消费一次
                    .build();

    private void soutStrs(List<String> strings) {
        System.out.println("size:" + strings.size());
        System.out.println("strs:" + strings.toString());
    }

    public static void main(String[] args) throws InterruptedException {
        BufferTriggerTest bufferTriggerTest = new BufferTriggerTest();
        Thread.sleep(10000);
        for (int i = 0; i < 523; i++) {
            bufferTriggerTest.bufferTrigger.enqueue(String.valueOf(i));
        }
        Thread.sleep(10000);
        for (int i = 0; i < 523; i++) {
            bufferTriggerTest.bufferTrigger.enqueue(String.valueOf(i));
        }
        bufferTriggerTest.bufferTrigger.manuallyDoTrigger();

    }
}
