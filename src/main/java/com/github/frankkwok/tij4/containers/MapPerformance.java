package com.github.frankkwok.tij4.containers;

import java.util.*;

/**
 * Page 653
 * Exercise 35: Modify MapPerformance.java to include tests of SlowMap.
 * Exercise 36: Modify SlowMap so that instead of two ArrayLists, it holds a single ArrayList of MapEntry objects.
 * Verify that the modified version works correctly. Using MapPerformance.java, test the speed of your new Map. Now
 * change the put( ) method so that it performs a sort( ) after each pair is entered, and modify get( ) to use
 * Collections.binarySearch( ) to look up the key. Compare the performance of the new version with the old ones.
 * Exercise 37: Modify SimpleHashMap to use ArrayLists instead of LinkedLists. Modify MapPerformance.java to compare the
 * performance of the two implementations.
 *
 * @author Frank Kwok on 2017/5/26.
 */
public class MapPerformance {
    static List<Test<Map<Integer, Integer>>> tests = new ArrayList<>();

    static {
        tests.add(new Test<Map<Integer, Integer>>("put") {
            @Override
            int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    map.clear();
                    for (int j = 0; j < size; j++) {
                        map.put(j, j);
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("get") {
            @Override
            int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++)
                    for (int j = 0; j < span; j++) {
                        map.get(j);
                    }
                return loops * span;
            }
        });
        tests.add(new Test<Map<Integer, Integer>>("iterate") {
            @Override
            int test(Map<Integer, Integer> map, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                return loops * map.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        else {
            Tester.defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 500, 10000, 50);
        }
        Tester.run(new SlowMap<>(), tests);
        Tester.run(new SlowMap2<>(), tests);
        Tester.run(new SlowMap3<>(), tests);
        Tester.run(new SimpleHashMap<>(), tests);
        Tester.run(new SimpleHashMap2<>(), tests);
        Tester.run(new TreeMap<>(), tests);
        Tester.run(new HashMap<>(), tests);
        Tester.run(new LinkedHashMap<>(), tests);
        Tester.run(new IdentityHashMap<>(), tests);
        Tester.run(new WeakHashMap<>(), tests);
        Tester.run(new Hashtable<>(), tests);
    }
}
