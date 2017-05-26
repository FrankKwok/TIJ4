package com.github.frankkwok.tij4.containers;

import java.util.HashMap;

/**
 * Page 653
 * Exercise 38: Look up the HashMap class in the JDK documentation. Create a HashMap, fill it with elements, and
 * determine the load factor. Test the lookup speed with this map, then attempt to increase the speed by making a new
 * HashMap with a larger initial capacity and copying the old map into the new one, then run your lookup speed test
 * again on the new map.
 *
 * @author Frank Kwok on 2017/5/26.
 */
public class MapLoadFactorTest {
    public static void main(String[] args) {
        Tester.run(new HashMap<>(16, 0.5f), MapPerformance.tests);
        Tester.run(new HashMap<>(16, 0.6f), MapPerformance.tests);
        Tester.run(new HashMap<>(16, 0.7f), MapPerformance.tests);
        Tester.run(new HashMap<>(16, 0.8f), MapPerformance.tests);
        Tester.run(new HashMap<>(16, 0.9f), MapPerformance.tests);
    }
}
