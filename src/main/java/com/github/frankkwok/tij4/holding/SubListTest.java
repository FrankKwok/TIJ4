package com.github.frankkwok.tij4.holding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Page 308
 * Exercise 7: Create a class, then make an initialized array of objects of your class. Fill a List from your array.
 * Create a subset of your List by using subList( ), then remove this subset from your List.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class SubListTest {
    private String[] strings = new String[]{"hello", "frank", "kwok"};

    public static void main(String[] args) {
        SubListTest slt = new SubListTest();
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, slt.strings);
        System.out.println(strings);
        List<String> subStrings = strings.subList(1, 2);
        System.out.println(subStrings);
        strings.removeAll(subStrings); // or use subStrings.clear();
        System.out.println(strings);
    }
}
