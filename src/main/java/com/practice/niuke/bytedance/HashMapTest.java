package com.practice.niuke.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Java中涉及到Byte，char和short类型的运算时，都会把这些类型转化为int类型，然后对int类型数值进行运算，最后得到int类型的结果。
 *
 * byte的取值范围为-128~127，占用1个字节（-2的7次方到2的7次方-1）
 *
 * short的取值范围为-32768~32767，占用2个字节（-2的15次方到2的15次方-1）
 *
 * int的取值范围为（-2147483648~2147483647），占用4个字节（-2的31次方到2的31次方-1）
 *
 * long的取值范围为（-9223372036854774808~9223372036854774807），占用8个字节（-2的63次方到2的63次方-1）
 *
 * @author : kai.dai
 * @date : 2020-05-13 09:30
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<Short, String> map = new HashMap<>();
        for (short i = 0; i < 100; i++) {
            map.put(i, String.valueOf(i));
            map.remove(i - (short)1);
        }
        System.out.println(map.size());
    }
}
