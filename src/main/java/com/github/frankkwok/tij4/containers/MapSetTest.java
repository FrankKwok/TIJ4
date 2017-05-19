package com.github.frankkwok.tij4.containers;

import com.github.frankkwok.tij4.util.Countries;

import java.util.*;

/**
 * Page 601
 * Exercise 2: Produce a Map and a Set containing all the countries that begin with ‘A’.
 * Exercise 3: Using Countries, fill a Set multiple times with the same data and verify that the Set ends up with only
 * one of each instance. Try this with HashSet, LinkedHashSet, and TreeSet.
 * Exercise 5: Modify CountingMapData.java to fully implement the flyweight by adding a custom EntrySet class like the
 * one in Countries.java. {@see CountingMapData.java}
 *
 * @author Frank Kwok on 2017/5/19.
 */
public class MapSetTest {
    public static void main(String[] args) {
        Map<String, String> aMap = new HashMap<>(Countries.capitals());
        aMap.entrySet().removeIf(entry -> !entry.getKey().startsWith("A"));
        System.out.println(aMap);

        Set<String> aSet = new HashSet<>(Countries.capitals().keySet());
        aSet.removeIf(string -> !string.startsWith("A"));
        System.out.println(aSet);

        HashSet<String> hashSet = new HashSet<>(aSet);
        System.out.println(hashSet);
        hashSet.addAll(aSet);
        System.out.println(hashSet);

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(aSet);
        System.out.println(linkedHashSet);
        linkedHashSet.addAll(aSet);
        System.out.println(linkedHashSet);

        TreeSet<String> treeSet = new TreeSet<>(aSet);
        System.out.println(treeSet);
        treeSet.addAll(aSet);
        System.out.println(treeSet);
    }
}
