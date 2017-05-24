package com.github.frankkwok.tij4.containers;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Page 635
 * Exercise 24: Following the example in SimpleHashMap.java, create and test a SimpleHashSet.l
 *
 * @author Frank Kwok on 2017/5/23.
 */
public class SimpleHashSet<E> extends AbstractSet<E> {
    private static final int SIZE = 997;

    @SuppressWarnings("unchecked")
    private LinkedList<E>[] buckets = new LinkedList[SIZE];

    @Override
    public int size() {
        int size = 0;
        for (LinkedList<E> bucket : buckets) {
            if (bucket != null) {
                size += bucket.size();
            }
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        int index = Math.abs(o.hashCode()) % SIZE;
        if (buckets[index] != null) {
            for (E e : buckets[index]) {
                if (e.equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        List<E> list = new ArrayList<>();
        for (LinkedList<E> bucket : buckets) {
            if (bucket != null) {
                list.addAll(bucket);
            }
        }
        Iterator<E> iterator = list.iterator();
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
    public Object[] toArray() {
        Object[] objects = new Object[size()];
        int index = 0;
        for (LinkedList<E> bucket : buckets) {
            if (bucket != null) {
                for (E e : bucket) {
                    objects[index++] = e;
                }
            }
        }
        return objects;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T[] toArray(T[] a) {
        Object[] objects = toArray();
        if (objects.length >= a.length) {
            System.arraycopy(objects, 0, a, 0, objects.length);
            return a;
        }
        T[] newArray = (T[]) Array.newInstance(a.getClass().getComponentType(), objects.length);
        System.arraycopy(objects, 0, newArray, 0, objects.length);
        return newArray;
    }

    @Override
    public boolean add(E e) {
        int index = Math.abs(e.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        for (E ee : buckets[index]) {
            if (ee.equals(e)) {
                return false;
            }
        }
        return buckets[index].add(e);
    }

    @Override
    public boolean remove(Object o) {
        int index = Math.abs(o.hashCode()) % SIZE;
        if (buckets[index] != null) {
            Iterator<E> iterator = buckets[index].iterator();
            while (iterator.hasNext()) {
                E e = iterator.next();
                if (e.equals(o)) {
                    iterator.remove();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean contained = true;
        for (Object object : c) {
            contained &= contains(object);
        }
        return contained;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean modified = false;
        for (E e : c) {
            modified |= add(e);
        }
        return modified;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean modified = false;
        for (LinkedList<E> bucket : buckets) {
            if (bucket != null) {
                Iterator<E> iterator = bucket.iterator();
                while (iterator.hasNext()) {
                    E e = iterator.next();
                    if (c.contains(e)) {
                        iterator.remove();
                        modified = true;
                    }
                }
            }
        }
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removed = false;
        for (Object object : c) {
            removed |= remove(object);
        }
        return removed;
    }

    @Override
    public void clear() {
        for (LinkedList<E> bucket : buckets) {
            if (bucket != null) {
                bucket.clear();
            }
        }
    }
}
