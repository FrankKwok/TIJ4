package com.github.frankkwok.tij4.generics;

import java.util.ArrayList;

/**
 * Page 519
 * Exercise 32: Verify that FixedSizeStack in GenericCast.java generates exceptions if you try to go out of its bounds.
 * Does this mean that bounds-checking code is not required?
 * Exercise 33: Repair GenericCast.java using an ArrayList.
 *
 * @author Frank Kwok on 2017/5/17.
 */
public class GenericCast {
    public static final int SIZE = 10;

    public static void main(String[] args) {
        FixedSizeStack<String> strings =
                new FixedSizeStack<>(SIZE);
        for (String s : "A B C D E F G H I J".split(" "))
            strings.push(s);
        for (int i = 0; i < SIZE; i++) {
            String s = strings.pop();
            System.out.print(s + " ");
        }
        strings.pop();
    }
}

class FixedSizeStack<T> {
    private int index = 0;
    private ArrayList<T> storage;

    public FixedSizeStack(int size) {
        storage = new ArrayList<>(size);
    }

    public void push(T item) {
        index++;
        storage.add(item);
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        return storage.remove(--index);
    }
}
