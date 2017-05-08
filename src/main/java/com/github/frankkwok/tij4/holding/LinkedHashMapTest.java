package com.github.frankkwok.tij4.holding;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Page 320
 * Exercise 24: Fill a LinkedHashMap with String keys and objects of your choice. Now extract the pairs, sort them based
 * on the keys, and reinsert them into the Map.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, Gerbil> map = new LinkedHashMap<>();
        map.put("Ruccy", new Gerbil(7));
        map.put("Fuzzy", new Gerbil(3));
        map.put("Spot", new Gerbil(5));

        System.out.println(map);

        Map<String, Gerbil> sortMap = new TreeMap<>();
        sortMap.putAll(map);

        map.clear();
        for (String key : sortMap.keySet()) {
            map.put(key, sortMap.get(key));
        }

        System.out.println(map);
    }
}
