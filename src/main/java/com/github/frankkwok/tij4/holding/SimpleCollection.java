package com.github.frankkwok.tij4.holding;

import java.util.HashSet;
import java.util.Set;

/**
 * Page 301
 * Exercise 2: Modify SimpleCollection.java to use a Set for c.
 *
 * @author Frank Kwok on 2017/4/23.
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Set<Integer> c = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            c.add(i);
        }
        for (Integer i : c) {
            System.out.print(i + ", ");
        }
    }
}
