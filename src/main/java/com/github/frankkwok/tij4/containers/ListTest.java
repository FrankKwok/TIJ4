package com.github.frankkwok.tij4.containers;

import com.github.frankkwok.tij4.util.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Page 601
 * Exercise 1: Create a List (try both ArrayList and LinkedList) and fill it using Countries. Sort the list and print
 * it, then apply Collections.shuffle( ) to the list repeatedly, printing it each time so that you can see how the
 * shuffle( ) method randomizes the list differently each time.
 *
 * @author Frank Kwok on 2017/5/19.
 */
public class ListTest {
    public static void main(String[] args) {
        System.out.println("ArrayList: ");
        List<String> list = new ArrayList<>(Countries.names(5));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

        System.out.println("LinkedList: ");
        list = new LinkedList<>(Countries.names(6));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
