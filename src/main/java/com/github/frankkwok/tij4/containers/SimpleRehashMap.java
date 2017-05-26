package com.github.frankkwok.tij4.containers;

import java.util.*;

/**
 * Page 654
 * Exercise 39: Add a private rehash( ) method to SimpleHashMap that is invoked when the load factor exceeds 0.75.
 * During rehashing, double the number of buckets, then search for the first prime number greater than that to determine
 * the new number of buckets.
 *
 * @author Frank Kwok on 2017/5/26.
 */
public class SimpleRehashMap<K, V> extends AbstractMap<K, V> {
    private static final int SIZE = 997;

    @SuppressWarnings("unchecked")
    private LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

    public V put(K key, V value) {
        rehash();
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % size();
        if (buckets[index] == null)
            buckets[index] = new LinkedList<>();
        LinkedList<MapEntry<K, V>> bucket = buckets[index];
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
        int index = Math.abs(key.hashCode()) % size();
        if (buckets[index] == null) return null;
        for (MapEntry<K, V> iPair : buckets[index])
            if (iPair.getKey().equals(key))
                return iPair.getValue();
        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket == null) continue;
            set.addAll(bucket);
        }
        return set;
    }

    @SuppressWarnings("unchecked")
    private void rehash() {
        int size = size();
        if (size / buckets.length > 0.75) {
            int newSize = size * 2;
            LinkedList<MapEntry<K, V>>[] newBuckets = new LinkedList[newSize];
            for (int i = 0; i < buckets.length; i++) {
                LinkedList<MapEntry<K, V>> linkedList = buckets[i];
                if (linkedList != null && !linkedList.isEmpty()) {
                    int index = Math.abs(linkedList.get(0).getKey().hashCode()) % newSize;
                    newBuckets[index] = linkedList;
                }
            }
            buckets = newBuckets;
        }
    }
}
