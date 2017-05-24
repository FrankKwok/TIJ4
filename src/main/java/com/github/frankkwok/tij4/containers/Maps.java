package com.github.frankkwok.tij4.containers;

import com.github.frankkwok.tij4.util.CountingMapData;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Page 624
 * Exercise 14: Show that java.util.Properties works in the above program.
 * <p>
 * Page 632
 * Exercise 16: Apply the tests in Maps.java to SlowMap to verify that it works. Fix anything in SlowMap that doesn’t
 * work correctly.
 *
 * @author Frank Kwok on 2017/5/23.
 */
public class Maps {
    public static void main(String[] args) {
        test(new HashMap<>());
        test(new TreeMap<>());
        test(new LinkedHashMap<>());
        test(new IdentityHashMap<>());
        test(new ConcurrentHashMap<>());
        test(new WeakHashMap<>());
        test(new Properties());
        test(new SlowMap<>());
    }

    private static void printKeys(Map<Object, Object> map) {
        System.out.print("Size = " + map.size() + ", ");
        System.out.print("Keys: ");
        System.out.println(map.keySet());
    }

    public static void test(Map<Object, Object> map) {
        System.out.println(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        map.putAll(new CountingMapData(25));
        printKeys(map);
        System.out.println("Values: ");
        System.out.println(map.values());
        System.out.println(map);
        System.out.println("map.containsKey(11): " + map.containsKey(11));
        System.out.println("map.get(11): " + map.get(11));
        System.out.println("map.containsValue(\"F0\"): " + map.containsValue("F0"));
        Object key = map.keySet().iterator().next();
        System.out.println("First key in map: " + key);
        map.remove(key);
        printKeys(map);
        map.clear();
        System.out.println("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        // Operations on the Set change the Map:
        map.keySet().removeAll(map.keySet());
        System.out.println("map.isEmpty(): " + map.isEmpty());
    }
}
