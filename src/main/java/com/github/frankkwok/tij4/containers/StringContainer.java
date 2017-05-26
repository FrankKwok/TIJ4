package com.github.frankkwok.tij4.containers;

import java.util.AbstractList;
import java.util.Arrays;

/**
 * Page 648
 * Exercise 31: Create a container that encapsulates an array of String, and that only allows adding Strings and getting
 * Strings, so that there are no casting issues during use. If the internal array isn’t big enough for the next add,
 * your container should automatically resize it. In main( ), compare the performance of your container with an
 * ArrayList<String>.
 *
 * @author Frank Kwok on 2017/5/26.
 */
public class StringContainer extends AbstractList<String> {
    private static final int DEFAULT_SIZE = 16;
    private String[] strings;
    private int size;

    public StringContainer() {
        strings = new String[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(String s) {
        if (size >= strings.length) {
            strings = Arrays.copyOf(strings, size * 2);
        }
        strings[size] = s;
        size++;
        return true;
    }

    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return strings[index];
    }

    @Override
    public void clear() {
        size = 0;
    }
}
