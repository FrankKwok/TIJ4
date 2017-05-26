package com.github.frankkwok.tij4.util;

import java.util.AbstractList;

/**
 * @author Frank Kwok on 2017/5/26.
 */
public class CountingIntegerList extends AbstractList<Integer> {
    private int size;

    public CountingIntegerList(int size) {
        this.size = size < 0 ? 0 : size;
    }

    @Override
    public Integer get(int index) {
        return index;
    }

    @Override
    public int size() {
        return size;
    }
}
