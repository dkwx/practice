package com.practice.concurrent;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author : kai.dai
 * @date : 2020-05-24 16:07
 */
public class AtomicStampedTest {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> reference = new AtomicStampedReference(1, 1);
        int version = reference.getStamp();
        int value = reference.getReference();
        boolean update = reference.compareAndSet(value, value + 100, version, version + 1);
        System.out.println(update);
        version = reference.getStamp();
        value = reference.getReference();
        reference.attemptStamp(value, -1);
        update = reference.compareAndSet(value, value + 1, version, version + 1);
        System.out.println(update);
        System.out.println(reference.getStamp());
        System.out.println(reference.getReference());
    }
}
