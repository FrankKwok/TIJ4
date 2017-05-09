package com.github.frankkwok.tij4.exceptions;

/**
 * Page 354
 * Exercise 12: Modify innerclasses/Sequence.java so that it throws an appropriate exception if you try to put in too
 * many elements.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 15; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
    }

    public void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i < items.length) i++;
        }
    }

    public Selector selector() {
        return new SequenceSelector();
    }
}

interface Selector {
    boolean end();

    Object current();

    void next();
}
