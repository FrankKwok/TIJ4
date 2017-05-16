package com.github.frankkwok.tij4.generics;

import java.util.Iterator;

/**
 * Page 471
 * Exercise 7: Use composition instead of inheritance to adapt Fibonacci to make it Iterable.
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class FibonacciAdapter implements Iterable<Integer> {
    private Fibonacci fibonacci;
    private int size;

    public FibonacciAdapter(int size) {
        fibonacci = new Fibonacci();
        this.size = size;
    }

    public static void main(String[] args) {
        for (Integer i : new FibonacciAdapter(10)) {
            System.out.print(i + " ");
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Integer next() {
                index++;
                return fibonacci.next();
            }
        };
    }
}
