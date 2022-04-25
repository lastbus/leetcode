package com.make.codetop;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author make
 * @create 2022-04-25
 */
public class M146_LRUCache_Easy extends LinkedHashMap<Integer, Integer> {

    private final int capacity;

    public M146_LRUCache_Easy(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }


    public int get(int i) {
        return getOrDefault(i, -1);
    }



    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }


}
