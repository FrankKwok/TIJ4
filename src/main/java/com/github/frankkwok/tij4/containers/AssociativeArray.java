package com.github.frankkwok.tij4.containers;

import com.github.frankkwok.tij4.util.TextFile;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Page 621
 * Exercise 12: Substitute a HashMap, a TreeMap and a LinkedHashMap in AssociativeArray .Java’s main( ).
 * Exercise 13: Use AssociativeArray Java to create a wordoccurrence counter, mapping String to Integer. Using the
 * net.mindview.util.TextFile utility in this book, open a text file and break up the words in that file using
 * whitespace and punctuation, and count the occurrence of the words in that file.
 *
 * @author Frank Kwok on 2017/5/19.
 */
public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public static void main(String[] args) {
        // Exercise 12
        Map<String, String> map = new HashMap<>();
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many objects!");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));

        map = new TreeMap<>();
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many objects!");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));


        map = new LinkedHashMap<>();
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
        try {
            map.put("extra", "object");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Too many objects!");
        }
        System.out.println(map);
        System.out.println(map.get("ocean"));

        // Exercise 13
        Map<String, Integer> wordCounter = new HashMap<>();
        for (String s : new TextFile(".gitignore")) {
            wordCounter.put(s, wordCounter.getOrDefault(s, 0) + 1);
        }
        System.out.println(wordCounter);
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; i++)
            if (key.equals(pairs[i][0]))
                return (V) pairs[i][1];
        return null;
    }

    public void put(K key, V value) {
        if (index >= pairs.length)
            throw new ArrayIndexOutOfBoundsException();
        pairs[index++] = new Object[]{key, value};
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < index; i++) {
            result.append(pairs[i][0].toString());
            result.append(" : ");
            result.append(pairs[i][1].toString());
            if (i < index - 1)
                result.append("\n");
        }
        return result.toString();
    }
}
