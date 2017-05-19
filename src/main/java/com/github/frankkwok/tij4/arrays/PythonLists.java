package com.github.frankkwok.tij4.arrays;

import java.util.*;

/**
 * Page 587
 * Exercise 25: Rewrite PythonLists.py in Java.
 *
 * @author Frank Kwok on 2017/5/19.
 */
public class PythonLists {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(list.getClass());
        System.out.println(list);
        System.out.println(list.get(4));
        list.add(6);
        Collections.addAll(list, 7, 8);
        System.out.println(list);
        List<Integer> subList = list.subList(2, 4);
        System.out.println(subList);

        MyList<Integer> list2 = new MyList<>(list);
        System.out.println(list2.getClass());
        System.out.println(list2.getReversed());
    }
}

class MyList<T> extends ArrayList<T> {
    MyList() {
    }

    MyList(Collection<? extends T> c) {
        super(c);
    }

    MyList<T> getReversed() {
        MyList<T> myList = new MyList<>();
        ListIterator<T> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            myList.add(listIterator.previous());
        }
        return myList;
    }
}
