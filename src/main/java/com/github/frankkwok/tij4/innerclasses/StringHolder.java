package com.github.frankkwok.tij4.innerclasses;

/**
 * Page 268
 * Exercise 2: Create a class that holds a String, and has a toString( ) method that displays this String. Add several
 * instances of your new class to a Sequence object, then display them
 * <p>
 * Page 269
 * Exercise 4: Add a method to the class Sequence.SequenceSelector that produces the reference to the outer class
 * Sequence.
 * <p>
 * Page 283
 * Exercise 22: Implement reverseSelector( ) in Sequence.java.
 *
 * @author Frank Kwok on 2017/4/13.
 */
public class StringHolder {
    private String string;

    public StringHolder(String string) {
        this.string = string;
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(new StringHolder("hold " + i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.println(selector.current());
            selector.next();
        }
        Selector reverseSelector = sequence.reverseSelector();
        while (!reverseSelector.end()) {
            System.out.println(reverseSelector.current());
            reverseSelector.next();
        }
    }

    @Override
    public String toString() {
        return string;
    }
}

interface Selector {
    boolean end();

    Object current();

    void next();
}

class Sequence {
    private Object[] items;
    private int next = 0;

    public Sequence(int size) {
        items = new Object[size];
    }

    public void add(Object x) {
        if (next < items.length)
            items[next++] = x;
    }

    public Selector selector() {
        return new SequenceSelector();
    }

    public Selector reverseSelector() {
        return new ReverseSelector();
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

        public Sequence outer() {
            return Sequence.this;
        }
    }

    private class ReverseSelector implements Selector {
        private int i = items.length - 1;

        @Override
        public boolean end() {
            return i == -1;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i > -1) {
                i--;
            }
        }
    }
}