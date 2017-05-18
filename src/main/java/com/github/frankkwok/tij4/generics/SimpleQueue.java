package com.github.frankkwok.tij4.generics;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Page 547
 * Exercise 41: Modify Fill2.java to use the classes in typeinfo.pets instead of the Coffee classes.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class SimpleQueue<T> implements Iterable<T> {
    private LinkedList<T> storage = new LinkedList<T>();

    public void add(T t) {
        storage.offer(t);
    }

    public T get() {
        return storage.poll();
    }

    public Iterator<T> iterator() {
        return storage.iterator();
    }
}
