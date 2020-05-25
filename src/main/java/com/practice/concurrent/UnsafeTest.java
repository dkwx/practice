package com.practice.concurrent;

import sun.misc.Unsafe;

/**
 * @author : kai.dai
 * @date : 2020-05-24 19:41
 */
public class UnsafeTest {
    private volatile int state = 0;
    private static final long stateOffSet;
    private static final Unsafe unsafe = UnsafeInstance.reflectGetUnsafe();

    public final boolean compareAndSwapState(int expect, int update) {
        return unsafe.compareAndSwapInt(this, stateOffSet, expect, update);

    }

    static {
        try {
            stateOffSet = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            throw new Error();
        }
    }

}
