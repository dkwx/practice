package com.practice.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author : kai.dai
 * @date : 2020-05-24 19:43
 */
public class UnsafeInstance {
    public static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
