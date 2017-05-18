package com.github.frankkwok.tij4.util;

/**
 * @author Frank Kwok on 2017/5/18.
 */
public interface SkipGenerator<T> extends Generator<T> {
    T next(int n);
}
