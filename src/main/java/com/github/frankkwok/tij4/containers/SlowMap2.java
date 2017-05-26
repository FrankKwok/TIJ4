package com.github.frankkwok.tij4.containers;

import java.util.*;

/**
 * Page 653
 * Exercise 36: Modify SlowMap so that instead of two ArrayLists, it holds a single ArrayList of MapEntry objects.
 * Verify that the modified version works correctly. Using MapPerformance.java, test the speed of your new Map. Now
 * change the put( ) method so that it performs a sort( ) after each pair is entered, and modify get( ) to use
 * Collections.binarySearch( ) to look up the key. Compare the performance of the new version with the old ones.
 *
 * @author Frank Kwok on 2017/5/26.
 */
public class SlowMap2<K, V> extends AbstractMap<K, V> {
    private List<MapEntry<K, V>> list = new ArrayList<>();

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                oldValue = list.get(i).getValue();
                found = true;
                list.get(i).setValue(value);
            }
        }
        if (!found) {
            list.add(new MapEntry<>(key, value));
        }
        return oldValue;
    }

    @Override
    public V get(Object key) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getKey().equals(key)) {
                return list.get(i).getValue();
            }
        }
        return null;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new HashSet<>(list);
    }
}
