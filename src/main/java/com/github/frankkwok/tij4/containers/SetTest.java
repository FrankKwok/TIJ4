package com.github.frankkwok.tij4.containers;

import com.github.frankkwok.tij4.util.CollectionData;
import com.github.frankkwok.tij4.util.RandomGenerator;

import java.util.*;

/**
 * Page 615
 * Exercise 9: Use RandomGenerator.String to fill a TreeSet, but use alphabetic ordering. Print the TreeSet to verify
 * the sort order.
 * Exercise 10: Using a LinkedList as your underlying implementation, define your own SortedSet.
 *
 * @author Frank Kwok on 2017/5/19.
 */
public class SetTest {
    public static void main(String[] args) {
        RandomGenerator.String gen = new RandomGenerator.String();
        TreeSet<String> treeSet = new TreeSet<>(new CollectionData<>(gen, 10));
        System.out.println(treeSet);

        SortedSet<String> sortedSet = new SortedSetImpl<>();
        for (int i = 0; i < 10; i++) {
            sortedSet.add(gen.next());
        }
        System.out.println(sortedSet);
    }
}

class SortedSetImpl<E> implements SortedSet<E> {
    private List<E> linkedList = new LinkedList<>();

    SortedSetImpl() {
    }

    private SortedSetImpl(List<E> linkedList) {
        this.linkedList = linkedList;
    }

    @Override
    public Comparator<? super E> comparator() {
        return null;
    }

    @Override
    public SortedSet<E> subSet(E fromElement, E toElement) {
        int fromIndex = linkedList.indexOf(fromElement);
        int toIndex = linkedList.indexOf(toElement);
        return new SortedSetImpl<>(linkedList.subList(fromIndex, toIndex));
    }

    @Override
    public SortedSet<E> headSet(E toElement) {
        int fromIndex = 0;
        int toIndex = linkedList.indexOf(toElement);
        return new SortedSetImpl<>(linkedList.subList(fromIndex, toIndex));
    }

    @Override
    public SortedSet<E> tailSet(E fromElement) {
        int fromIndex = linkedList.indexOf(fromElement);
        int toIndex = linkedList.size();
        return new SortedSetImpl<>(linkedList.subList(fromIndex, toIndex));
    }

    @Override
    public E first() {
        return ((LinkedList<E>) linkedList).getFirst();
    }

    @Override
    public E last() {
        return ((LinkedList<E>) linkedList).getLast();
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return linkedList.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return linkedList.iterator();
    }

    @Override
    public Object[] toArray() {
        return linkedList.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return linkedList.toArray(a);
    }

    @Override
    public boolean add(E e) {
        if (linkedList.contains(e)) {
            return false;
        } else {
            linkedList.add(e);
            linkedList.sort(null);
            return true;
        }
    }

    @Override
    public boolean remove(Object o) {
        return linkedList.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return linkedList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E e : c) {
            if (!linkedList.contains(e)) {
                linkedList.add(e);
                result = true;
            }
        }
        linkedList.sort(null);
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return linkedList.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return linkedList.removeAll(c);
    }

    @Override
    public void clear() {
        linkedList.clear();
    }

    @Override
    public String toString() {
        return linkedList.toString();
    }
}
