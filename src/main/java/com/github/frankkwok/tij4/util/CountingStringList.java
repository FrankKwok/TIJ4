package com.github.frankkwok.tij4.util;

import java.util.AbstractList;

/**
 * @author Frank Kwok on 2017/5/26.
 */
public class CountingStringList extends AbstractList<String> {
    private int size;

    public CountingStringList(int size) {
        this.size = size < 0 ? 0 : size;
    }

    @Override
    public String get(int index) {
        return String.valueOf(index);
    }

    @Override
    public int size() {
        return size;
    }
}
