package com.github.frankkwok.tij4.containers;

import java.util.*;

/**
 * Page 648
 * Exercise 33: Create a FastTraversalLinkedList that internally uses a LinkedList for rapid insertions and removals,
 * and an ArrayList for rapid traversals and get( ) operations. Test it by modifying ListPerformance.java.
 *
 * @author Frank Kwok on 2017/5/26.
 */
public class FastTraversalLinkedList<E> extends AbstractList<E> {
    private LinkedList<E> linkedList = new LinkedList<>();
    private ArrayList<E> arrayList = new ArrayList<>();

    private boolean changed;

    public static void main(String[] args) {
        List<Test<List<String>>> testList = Arrays.asList(ListPerformance.tests.get(0),
                ListPerformance.tests.get(1), ListPerformance.tests.get(4), ListPerformance.tests.get(5));
        ListPerformance.ListTester.run(new FastTraversalLinkedList<>(), testList);
        ListPerformance.ListTester.run(new ArrayList<>(), testList);
        ListPerformance.ListTester.run(new LinkedList<>(), testList);
    }

    @Override
    public int size() {
        synch();
        return arrayList.size();
    }

    @Override
    public boolean add(E e) {
        changed = true;
        return linkedList.add(e);
    }

    @Override
    public void add(int index, E element) {
        changed = true;
        linkedList.add(index, element);
    }

    @Override
    public Iterator<E> iterator() {
        synch();
        Iterator<E> iterator = arrayList.iterator();
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public E next() {
                return iterator.next();
            }
        };
    }

    @Override
    public E remove(int index) {
        changed = true;
        return linkedList.remove(index);
    }

    @Override
    public boolean remove(Object o) {
        changed = linkedList.remove(o);
        return changed;
    }

    @Override
    public E get(int index) {
        synch();
        return arrayList.get(index);
    }

    private void synch() {
        if (changed) {
            arrayList = new ArrayList<>(linkedList);
        }
    }
}
