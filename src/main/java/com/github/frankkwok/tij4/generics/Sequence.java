package com.github.frankkwok.tij4.generics;

/**
 * Page 466
 * Exercise 4: "Generify" innerclasses/Sequence.java.
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class Sequence<T> {
    private T[] items;
    private int next = 0;

    @SuppressWarnings("unchecked")
    public Sequence(int size) {
        items = (T[]) new Object[size];
    }

    public static void main(String[] args) {
        Sequence<String> sequence = new Sequence<>(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }

    public void add(T t) {
        if (next < items.length) {
            items[next++] = t;
        }
    }

    private class SequenceSelector implements Selector<T> {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public T current() {
            return items[i];
        }

        public void next() {
            if (i < items.length) i++;
        }
    }

    public Selector<T> selector() {
        return new SequenceSelector();
    }
}

interface Selector<T> {
    boolean end();

    T current();

    void next();
}
