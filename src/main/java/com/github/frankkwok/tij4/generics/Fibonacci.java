package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.util.Generator;

/**
 * Page 471
 * Exercise 7: Use composition instead of inheritance to adapt Fibonacci to make it Iterable.
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class Fibonacci implements Generator<Integer> {
    private int count = 0;

    public Integer next() {
        return fib(count++);
    }

    private int fib(int n) {
        if (n < 2) {
            return 1;
        } else {
            return fib(n - 2) + fib(n - 1);
        }
    }
}
