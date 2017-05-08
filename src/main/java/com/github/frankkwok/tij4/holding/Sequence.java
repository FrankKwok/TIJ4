package com.github.frankkwok.tij4.holding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Page 301
 * Exercise 3: Modify innerclasses/Sequence.java so that you can add any number of elements to it.
 * <p>
 * Page 310
 * Exercise 9: Modify innerclasses/Sequence.java so that Sequence works with an Iterator instead of a Selector.
 *
 * @author Frank Kwok on 2017/4/23.
 */
public class Sequence {
    private List<Object> items;

    private Sequence(int size) {
        items = new ArrayList<>(size);
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++)
            sequence.add(Integer.toString(i));
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print(selector.current() + " ");
            selector.next();
        }
        System.out.println();
        Iterator iterator = sequence.interator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }

    public void add(Object x) {
        items.add(x);
    }

    public Iterator interator() {
        return new Iterator() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < items.size();
            }

            @Override
            public Object next() {
                return items.get(index++);
            }
        };
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.size();
        }

        @Override
        public Object current() {
            return items.get(i);
        }

        @Override
        public void next() {
            if (i < items.size()) {
                i++;
            }
        }
    }

    private Selector selector() {
        return new SequenceSelector();
    }
}

interface Selector {
    boolean end();

    Object current();

    void next();
}
