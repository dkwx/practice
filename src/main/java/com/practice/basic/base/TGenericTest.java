package com.practice.basic.base;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : kai.dai
 * @date : 2020-05-31 12:37
 */
public class TGenericTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "hollis");
        map.put("age", "22");
        System.out.println(map.get("name"));
        System.out.println(map.get("age"));
    }



}
