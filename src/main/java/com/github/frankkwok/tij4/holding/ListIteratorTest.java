package com.github.frankkwok.tij4.holding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Page 311
 * Exercise 12: Create and populate a List<Integer>. Create a second List<Integer> of the same size as the first, and
 * use ListIterators to read elements from the first List and insert them into the second in reverse order. (You may
 * want to explore a number of different ways to solve this problem.)
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class ListIteratorTest {
    public static void main(String[] args) {
        List<Integer> ints1 = new ArrayList<>();
        Collections.addAll(ints1, 0, 1, 2, 3, 4);
        List<Integer> ints2 = new ArrayList<>();
        Collections.addAll(ints2, 9, 8, 7, 6, 5);

        System.out.println("ints1: " + ints1);
        System.out.println("ints2: " + ints2);

        ListIterator<Integer> listIterator1 = ints1.listIterator();
        ListIterator<Integer> listIterator2 = ints2.listIterator(ints2.size());

        while (listIterator1.hasNext()) {
            Integer i = listIterator1.next();
            System.out.print(i + " ");
        }

        while (listIterator1.hasPrevious()) {
            listIterator2.add(listIterator1.previous());
        }
        System.out.println();

        System.out.println("ints1: " + ints1);
        System.out.println("ints2: " + ints2);
    }
}
