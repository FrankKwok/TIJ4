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
public class SlowMap3<K, V> extends AbstractMap<K, V> {
    private List<MapEntry<K, V>> list = new ArrayList<>();

    @Override
    public V put(K key, V value) {
        int index = Collections.binarySearch(list, new MapEntry<>(key, null));
        if (index < 0) {
            list.add(new MapEntry<>(key, value));
            Collections.sort(list);
            return null;
        } else {
            V oldValue = list.get(index).getValue();
            list.get(index).setValue(value);
            return oldValue;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public V get(Object key) {
        int index = Collections.binarySearch(list, new MapEntry<>((K) key, null));
        return index < 0 ? null : list.get(index).getValue();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return new HashSet<>(list);
    }
}
