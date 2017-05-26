package com.github.frankkwok.tij4.containers;

import java.util.AbstractList;
import java.util.Arrays;

/**
 * Page 648
 * Exercise 32: Repeat the previous exercise for a container of int, and compare the performance to an
 * ArrayList<Integer>. In your performance comparison, include the process of incrementing each object in the container.
 *
 * @author Frank Kwok on 2017/5/26.
 */
public class IntContainer extends AbstractList<Integer> {
    private static final int DEFAULT_SIZE = 16;
    private int[] ints;
    private int size;

    public IntContainer() {
        ints = new int[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Integer integer) {
        if (size >= ints.length) {
            ints = Arrays.copyOf(ints, size * 2);
        }
        ints[size] = integer;
        size++;
        return true;
    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return ints[index];
    }

    @Override
    public void clear() {
        size = 0;
    }
}
