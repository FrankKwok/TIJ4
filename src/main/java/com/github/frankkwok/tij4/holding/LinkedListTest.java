package com.github.frankkwok.tij4.holding;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Page 313
 * Exercise 14: Create an empty LinkedList<Integer>. Using a Listlterator, add Integers to the List by always inserting
 * them in the middle of the List.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class LinkedListTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        System.out.println(list);

        for (int i = 0; i < 10; i++) {
            ListIterator<Integer> iterator = list.listIterator(list.size() / 2);
            iterator.add(i);
        }
        System.out.println(list);
    }
}
