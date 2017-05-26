package com.github.frankkwok.tij4.containers;

import com.github.frankkwok.tij4.util.CountingGenerator;
import com.github.frankkwok.tij4.util.CountingStringList;
import com.github.frankkwok.tij4.util.Generated;

import java.util.*;

/**
 * Page 647
 * Exercise 29: Modify ListPerformance.java so that the Lists hold String objects instead of Integers. Use a Generator
 * from the Arrays chapter to create test values.
 * <p>
 * Page 648
 * Exercise 30: Compare the performance of Collections.sort( ) between an ArrayList and a LinkedList.
 * Exercise 31: Create a container that encapsulates an array of String, and that only allows adding Strings and getting
 * Strings, so that there are no casting issues during use. If the internal array isn’t big enough for the next add,
 * your container should automatically resize it. In main( ), compare the performance of your container with an
 * ArrayList<String>.
 *
 * @author Frank Kwok on 2017/5/26.
 */
public class ListPerformance {
    private static Random rand = new Random();
    private static int reps = 1000;
    static List<Test<List<String>>> tests = new ArrayList<>();
    private static List<Test<LinkedList<String>>> qTests = new ArrayList<>();

    static {
        tests.add(new Test<List<String>>("add") {
            int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int listSize = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < listSize; j++) {
                        list.add(String.valueOf(j));
                    }
                }
                return loops * listSize;
            }
        });
        tests.add(new Test<List<String>>("get") {
            int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++) {
                    list.get(rand.nextInt(listSize));
                }
                return loops;
            }
        });
        tests.add(new Test<List<String>>("set") {
            int test(List<String> list, TestParam tp) {
                int loops = tp.loops * reps;
                int listSize = list.size();
                for (int i = 0; i < loops; i++) {
                    list.set(rand.nextInt(listSize), "47");
                }
                return loops;
            }
        });
        tests.add(new Test<List<String>>("iteradd") {
            int test(List<String> list, TestParam tp) {
                final int LOOPS = 1000000;
                int half = list.size() / 2;
                ListIterator<String> it = list.listIterator(half);
                for (int i = 0; i < LOOPS; i++) {
                    it.add("47");
                }
                return LOOPS;
            }
        });
        tests.add(new Test<List<String>>("insert") {
            int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                for (int i = 0; i < loops; i++) {
                    list.add(5, "47");
                }
                return loops;
            }
        });
        tests.add(new Test<List<String>>("remove") {
            int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingStringList(size));
                    while (list.size() > 5) {
                        list.remove(5);
                    }
                }
                return loops * size;
            }
        });
        tests.add(new Test<List<String>>("sort") {
            @Override
            int test(List<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingStringList(size));
                    Collections.sort(list);
                }
                return loops;
            }
        });

        qTests.add(new Test<LinkedList<String>>("addFirst") {
            int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addFirst("47");
                }
                return loops * size;
            }
        });
        qTests.add(new Test<LinkedList<String>>("addLast") {
            int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    for (int j = 0; j < size; j++)
                        list.addLast("47");
                }
                return loops * size;
            }
        });
        qTests.add(
                new Test<LinkedList<String>>("rmFirst") {
                    int test(LinkedList<String> list, TestParam tp) {
                        int loops = tp.loops;
                        int size = tp.size;
                        for (int i = 0; i < loops; i++) {
                            list.clear();
                            list.addAll(new CountingStringList(size));
                            while (list.size() > 0) {
                                list.removeFirst();
                            }
                        }
                        return loops * size;
                    }
                });
        qTests.add(new Test<LinkedList<String>>("rmLast") {
            int test(LinkedList<String> list, TestParam tp) {
                int loops = tp.loops;
                int size = tp.size;
                for (int i = 0; i < loops; i++) {
                    list.clear();
                    list.addAll(new CountingStringList(size));
                    while (list.size() > 0) {
                        list.removeLast();
                    }
                }
                return loops * size;
            }
        });
    }

    public static void main(String[] args) {
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        Tester<List<String>> arrayTest = new Tester<List<String>>(null, tests.subList(1, 3)) {
            @Override
            protected List<String> initialize(int size) {
                String[] ia = Generated.array(String.class, new CountingGenerator.String(), size);
                return Arrays.asList(ia);
            }
        };
        arrayTest.setHeadline("Array as List");
        arrayTest.timedTest();
        Tester<List<String>> containerTester = new Tester<>(new StringContainer(), tests.subList(0, 2));
        containerTester.setHeadline("String Container");
        containerTester.timedTest();
        Tester.defaultParams = TestParam.array(10, 5000, 100, 5000, 1000, 1000, 10000, 200);
        if (args.length > 0)
            Tester.defaultParams = TestParam.array(args);
        ListTester.run(new ArrayList<>(), tests);
        ListTester.run(new LinkedList<>(), tests);
        ListTester.run(new Vector<>(), tests);
        Tester.fieldWidth = 12;
        Tester<LinkedList<String>> qTest = new Tester<>(new LinkedList<>(), qTests);
        qTest.setHeadline("Queue tests");
        qTest.timedTest();
    }

    static class ListTester extends Tester<List<String>> {
        public ListTester(List<String> container, List<Test<List<String>>> tests) {
            super(container, tests);
        }

        @Override
        protected List<String> initialize(int size) {
            container.clear();
            container.addAll(new CountingStringList(size));
            return container;
        }

        public static void run(List<String> list, List<Test<List<String>>> tests) {
            new ListTester(list, tests).timedTest();
        }
    }
}


