package com.github.frankkwok.tij4.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Page 584
 * Exercise 22: Show that the results of performing a binarySearch( ) on an unsorted array are unpredictable.
 * Exercise 23: (2) Create an array of Integer, fill it with random int values (using autoboxing), and sort it into
 * reverse order using a Comparator.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class SortOrSerachTest {
    public static void main(String[] args) {
        int[] ints = {3, 2, 5, 4, 6};
        System.out.println(Arrays.binarySearch(ints, 2));

        Integer[] integers = new Integer[]{9, 5, 0, 2, 3, 1, 7};
        Arrays.sort(integers, Comparator.reverseOrder());
        System.out.println(Arrays.toString(integers));
    }
}
