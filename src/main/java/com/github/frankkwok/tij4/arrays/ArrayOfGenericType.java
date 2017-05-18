package com.github.frankkwok.tij4.arrays;

import java.util.ArrayList;

/**
 * Page 567
 * Exercise 8: Demonstrate the assertions in the previous paragraph.
 * Exercise 10: Modify ArrayOfGenerics .Java to use containers instead of arrays. Show that you can eliminate the
 * compile-time warnings.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class ArrayOfGenericType<T> {
//    T[] array;

    private ArrayList<T> arrayList;
    private int size;

    public ArrayOfGenericType(int size) {
//        array = (T[]) new Object[size];
        arrayList = new ArrayList<>();
        this.size = size;
    }
}
