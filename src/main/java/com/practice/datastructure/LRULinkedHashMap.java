package com.practice.datastructure;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : kai.dai
 * @date : 2020-05-23 21:32
 */
public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    public LRULinkedHashMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor, true);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > 3;
    }

    public static void main(String[] args) {
        Map<String, String> map = new LRULinkedHashMap<String, String>(8, 0.75f);
        map.put("a", "1");
        System.out.println(map);
        map.put("b", "1");
        System.out.println(map);
        map.put("c", "1");
        System.out.println(map);
        map.get("a");
        map.get("a");
        map.put("d", "1");
        System.out.println(map);
    }

}
