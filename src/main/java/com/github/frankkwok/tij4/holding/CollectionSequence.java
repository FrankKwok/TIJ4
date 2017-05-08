package com.github.frankkwok.tij4.holding;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;

/**
 * Page 325
 * Exercise 30: Modify CollectionSequence.java so that it does not inherit from AbstractCollection, but instead
 * implements Collection.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class CollectionSequence implements Collection<String> {
    private String[] strings = new String[]{"Hello", "Frank", "Kwok"};

    public static void main(String[] args) {
        display(new CollectionSequence());
        display(new CollectionSequence().iterator());
    }

    public static void display(Iterator<String> it) {
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    public static void display(Collection<String> strings) {
        for (String s : strings) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        return strings.length;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (String s : strings) {
            if (s.equals(o)) {
                return true;
            }
        }
        return false;
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

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[strings.length];
        System.arraycopy(strings, 0, objects, 0, strings.length);
        return objects;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        Class<?> type = a.getClass().getComponentType();
        T[] ts = (T[]) Array.newInstance(type, strings.length);
        System.arraycopy(strings, 0, ts, 0, strings.length);
        return ts;
    }

    @Override
    public boolean add(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean containsAll = true;
        for (Object o : c) {
            if (!contains(o)) {
                containsAll = false;
            }
        }
        return containsAll;
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
