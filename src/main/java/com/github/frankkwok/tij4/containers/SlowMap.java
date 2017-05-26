package com.github.frankkwok.tij4.containers;

import com.github.frankkwok.tij4.util.TextFile;

import java.util.*;

/**
 * Page 632
 * Exercise 15: Repeat Exercise 13 using a SlowMap
 * Exercise 17: Implement the rest of the Map interface for SlowMap.
 *
 * @author Frank Kwok on 2017/5/23.
 */
public class SlowMap<K, V> implements Map<K, V> {
    private List<K> keys = new ArrayList<>();
    private List<V> values = new ArrayList<>();

    public static void main(String[] args) {
        Map<String, Integer> wordCounter = new SlowMap<>();
        for (String s : new TextFile(".gitignore")) {
            wordCounter.put(s, wordCounter.getOrDefault(s, 0) + 1);
        }
        System.out.println(wordCounter);
    }

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @SuppressWarnings("unckecked")
    @Override
    public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    public V get(Object key) {
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    @Override
    public V put(K key, V value) {
        V oldValue = get(key);
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else
            values.set(keys.indexOf(key), value);
        return oldValue;
    }

    @Override
    public V remove(Object key) {
        V value = get(key);
        keys.remove(key);
        values.remove(value);
        return value;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    public Set<K> keySet() {
        return new AbstractSet<K>() {
            @Override
            public Iterator<K> iterator() {
                return keys.iterator();
            }

            @Override
            public int size() {
                return keys.size();
            }
        };
    }

    @Override
    public Collection<V> values() {
        return values;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        Iterator<K> ki = keys.iterator();
        Iterator<V> vi = values.iterator();
        while (ki.hasNext())
            set.add(new MapEntry<>(ki.next(), vi.next()));
        return set;
    }
}

class MapEntry<K, V> implements Map.Entry<K, V>, Iterable<MapEntry<K, V>>, Comparable<MapEntry<K, V>> {
    private K key;
    private V value;

    private MapEntry<K, V> previous = null;

    MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    MapEntry(K key, V value, MapEntry<K, V> previous) {
        this.key = key;
        this.value = value;
        this.previous = previous;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V v) {
        V result = value;
        value = v;
        return result;
    }

    public MapEntry<K, V> getPrevious() {
        return previous;
    }

    public void setPrevious(MapEntry<K, V> previous) {
        this.previous = previous;
    }

    @Override
    public Iterator<MapEntry<K, V>> iterator() {
        return new Iterator<MapEntry<K, V>>() {
            MapEntry<K, V> current = MapEntry.this;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public MapEntry<K, V> next() {
                MapEntry<K, V> result = current;
                current = current.previous;
                return result;
            }
        };
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (!(otherObject instanceof MapEntry)) {
            return false;
        }
        MapEntry other = (MapEntry) otherObject;
        return Objects.equals(key, other.key);
    }

    public String toString() {
        return key + "=" + value;
    }

    public int size() {
        int size = 0;
        MapEntry<K, V> current = this;
        while (current != null) {
            size++;
            current = current.previous;
        }
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(MapEntry<K, V> other) {
        return Integer.compare(key.hashCode(), other.key.hashCode());
    }
}
