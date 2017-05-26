package com.github.frankkwok.tij4.containers;

import java.util.*;

/**
 * Page 653
 * Exercise 37: Modify SimpleHashMap to use ArrayLists instead of LinkedLists. Modify MapPerformance.java to compare the
 * performance of the two implementations.
 *
 * @author Frank Kwok on 2017/5/26.
 */
public class SimpleHashMap2<K, V> extends AbstractMap<K, V> {
    private static final int SIZE = 997;

    @SuppressWarnings("unchecked")
    private ArrayList<MapEntry<K, V>>[] buckets = new ArrayList[SIZE];

    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new ArrayList<>();
        }
        ArrayList<MapEntry<K, V>> bucket = buckets[index];
        MapEntry<K, V> pair = new MapEntry<>(key, value);
        boolean found = false;
        ListIterator<MapEntry<K, V>> it = bucket.listIterator();
        while (it.hasNext()) {
            MapEntry<K, V> iPair = it.next();
            if (iPair.getKey().equals(key)) {
                oldValue = iPair.getValue();
                it.set(pair);
                found = true;
                break;
            }
        }
        if (!found)
            buckets[index].add(pair);
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for (MapEntry<K, V> iPair : buckets[index]) {
            if (iPair.getKey().equals(key)) {
                return iPair.getValue();
            }
        }

        return null;
    }


    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (ArrayList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            set.addAll(bucket);
        }
        return set;
    }

    public static void main(String[] args) {

    }
}
