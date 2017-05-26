package com.github.frankkwok.tij4.containers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Page 648
 * Exercise 32: Repeat the previous exercise for a container of int, and compare the performance to an
 * ArrayList<Integer>. In your performance comparison, include the process of incrementing each object in the container.
 *
 * @author Frank Kwok on 2017/5/26.
 */
public class IntListPerformance {
    private static Random random = new Random();
    private static List<Test<List<Integer>>> tests = new ArrayList<>();

    static {
        tests.add(new Test<List<Integer>>("add") {
            @Override
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++) {
                        list.add(i);
                    }
                }
                return loops * size;
            }
        });

        tests.add(new Test<List<Integer>>("get") {
            @Override
            int test(List<Integer> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops * size; i++) {
                    list.get(random.nextInt(list.size()));
                }
                return loops * size;
            }
        });
    }

    public static void main(String[] args) {
        Tester<List<Integer>> containerTester = new Tester<>(new IntContainer(), tests);
        containerTester.setHeadline("Int Container");
        containerTester.timedTest();
        Tester<List<Integer>> arrayListTester = new Tester<>(new ArrayList<>(), tests);
        arrayListTester.setHeadline("Array List");
        arrayListTester.timedTest();
        Tester<List<Integer>> linkedListTester = new Tester<>(new LinkedList<>(), tests);
        linkedListTester.setHeadline("Linked List");
        linkedListTester.timedTest();
    }
}
