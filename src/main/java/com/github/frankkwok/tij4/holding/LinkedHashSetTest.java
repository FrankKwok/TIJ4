package com.github.frankkwok.tij4.holding;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Page 319
 * Exercise 19: Repeat the previous exercise with a HashSet and LinkedHashSet.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class LinkedHashSetTest {
    public static void main(String[] args) {
        System.out.println("HashSet: ");
        Set<String> set = new HashSet<>();
        set.add("Frank");
        set.add("Kwok");
        set.add("Hello");
        set.add("World");
        System.out.println(set);
        System.out.println("LinkedHashSet: ");
        set = new LinkedHashSet<>();
        set.add("Frank");
        set.add("Kwok");
        set.add("Hello");
        set.add("World");
        System.out.println(set);
    }
}
