package com.github.frankkwok.tij4.holding;

import java.util.*;

/**
 * Page 330
 * Exercise 32: Following the example of MultilterableClass, add reversed( ) and randomized( ) methods to
 * NonCollectionSequence.java, as well as making NonCollectionSequence implement Iterable, and show that all the
 * approaches work in foreach statements.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class NonCollectionSequence extends StringSequence implements Iterable<String> {
    public static void main(String[] args) {
        NonCollectionSequence ncs = new NonCollectionSequence();
        for (String s : ncs) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : ncs.reversed()) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (String s : ncs.randomized()) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < strings.length;
            }

            @Override
            public String next() {
                return strings[index++];
            }
        };
    }

    public Iterable<String> reversed() {
        return () -> new Iterator<String>() {
            private int index = strings.length;

            @Override
            public boolean hasNext() {
                return index > 0;
            }

            @Override
            public String next() {
                return strings[--index];
            }
        };
    }

    public Iterable<String> randomized() {
        return () -> {
            List<String> randomList = new ArrayList<>(Arrays.asList(strings));
            Collections.shuffle(randomList);
            return randomList.iterator();
        };
    }
}

class StringSequence {
    protected String[] strings = new String[]{"Hello", "World", "Frank", "Kwok"};
}
