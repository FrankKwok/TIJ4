package com.github.frankkwok.tij4.containers;

import com.github.frankkwok.tij4.util.TextFile;

import java.io.IOException;
import java.util.*;

/**
 * Page 634
 * Exercise 19: Repeat Exercise 13 using a SimpleHashMap.
 * Exercise 20: Modify SimpleHashMap so that it reports collisions, and test this by adding the same data set twice so
 * that you see collisions.
 * Exercise 21: Modify SimpleHashMap so that it reports the number of "probes" necessary when collisions occur. That is,
 * how many calls to next( ) must be made on the Iterators that walk the LinkedLists looking for matches?
 * Exercise 22: Implement the clear( ) and remove( ) methods for SimpleHashMap.
 * <p>
 * Page 635
 * Exercise 23: Implement the rest of the Map interface for SimpleHashMap.
 * Exercise 25: Instead of using a Listlterator for each bucket, modify MapEntry so that it is a self-contained singly
 * linked list (each MapEntry should have a forward link to the next MapEntry). Modify the rest of the code in
 * SimpleHashMap.java so that this new approach works correctly.
 *
 * @author Frank Kwok on 2017/5/23.
 */
public class SimpleHashMap<K, V> implements Map<K, V> {
    private static final int SIZE = 997;

    @SuppressWarnings("unchecked")
    private MapEntry<K, V>[] buckets = new MapEntry[SIZE];

    public static void main(String[] args) throws IOException {
        // Exercise 19, 20
        Map<String, Integer> wordCounter = new SimpleHashMap<>();
        for (String s : new TextFile(".gitignore")) {
            wordCounter.put(s, wordCounter.getOrDefault(s, 0) + 1);
        }
        System.out.println(wordCounter);
    }

    @Override
    public int size() {
        int size = 0;
        for (MapEntry<K, V> bucket : buckets) {
            if (bucket != null) {
                size += bucket.size();
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return false;
        }
        for (MapEntry<K, V> entry : buckets[index]) {
            if (entry.getKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (MapEntry<K, V> bucket : buckets) {
            if (bucket != null) {
                for (MapEntry<K, V> entry : bucket) {
                    if (entry.getValue().equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        }
        for (MapEntry<K, V> entry : buckets[index]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new MapEntry<>(key, value);
            return null;
        }
        for (MapEntry<K, V> entry : buckets[index]) {
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                entry.setValue(value);
                return oldValue;
            }
        }
        MapEntry<K, V> entry = new MapEntry<>(key, value, buckets[index]);
        buckets[index] = entry;
        return null;
    }

    @Override
    public V remove(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            return null;
        }
        MapEntry<K, V> current = buckets[index];
        if (current.getKey().equals(key)) {
            V value = current.getValue();
            buckets[index] = current.getPrevious();
            return value;
        }
        if (current.getPrevious() != null && !current.getPrevious().getKey().equals(key)) {
            current = current.getPrevious();
        }
        if (current.getPrevious() == null) {
            return null;
        }

        MapEntry<K, V> previous = current.getPrevious();
        current.setPrevious(previous.getPrevious());
        return previous.getValue();
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = null;
        }
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (MapEntry<K, V> bucket : buckets) {
            if (bucket != null) {
                for (MapEntry<K, V> entry : bucket) {
                    set.add(entry.getKey());
                }
            }
        }
        return set;
    }

    @Override
    public Collection<V> values() {
        Collection<V> collection = new ArrayList<>();
        for (MapEntry<K, V> bucket : buckets) {
            if (bucket != null) {
                for (MapEntry<K, V> entry : bucket) {
                    collection.add(entry.getValue());
                }
            }
        }
        return collection;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (MapEntry<K, V> bucket : buckets) {
            if (bucket != null) {
                for (MapEntry<K, V> entry : bucket) {
                    set.add(entry);
                }
            }
        }
        return set;
    }
}
