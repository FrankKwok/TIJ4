package com.github.frankkwok.tij4.containers;

import java.util.*;

/**
 * Page 650
 * Exercise 34: Modify SetPerformance.java so that the Sets hold String objects instead of Integers. Use a Generator
 * from the Arrays chapter to create test values.
 *
 * @author Frank Kwok on 2017/5/26.
 */
public class SetPerformance {
    private static List<Test<Set<String>>> tests = new ArrayList<>();

    static {
        tests.add(new Test<Set<String>>("add") {
            @Override
            int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    set.clear();
                    for (int j = 0; j < size; j++) {
                        set.add(String.valueOf(j));
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<Set<String>>("contains") {
            @Override
            int test(Set<String> set, TestParam tp) {
                int loops = tp.loops;
                int span = tp.size * 2;
                for (int i = 0; i < loops; i++)
                    for (int j = 0; j < span; j++) {
                        set.contains(String.valueOf(j));
                    }
                return loops * span;
            }
        });
        tests.add(new Test<Set<String>>("iterate") {
            @Override
            int test(Set<String> set, TestParam tp) {
                int loops = tp.loops * 10;
                for (int i = 0; i < loops; i++) {
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                }
                return loops * set.size();
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            Tester.defaultParams = TestParam.array(args);
        }
        Tester.fieldWidth = 10;
        Tester.run(new TreeSet<>(), tests);
        Tester.run(new HashSet<>(), tests);
        Tester.run(new LinkedHashSet<>(), tests);
    }
}

