package com.github.frankkwok.tij4.generics.coffee;

/**
 * @author Frank Kwok on 2017/5/10.
 */
public class Coffee {
    private static long counter = 0;

    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
