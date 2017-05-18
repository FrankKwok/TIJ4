package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.typeinfo.pets.Cat;
import com.github.frankkwok.tij4.typeinfo.pets.Dog;
import com.github.frankkwok.tij4.typeinfo.pets.Pet;
import com.github.frankkwok.tij4.util.Generator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Page 547
 * Exercise 41: Modify Fill2.java to use the classes in typeinfo.pets instead of the Coffee classes.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class Fill2Test {
    public static void main(String[] args) {
        List<Pet> petList = new ArrayList<>();
        Fill2.fill(new AddableCollectionAdapter<Pet>(petList), Pet.class, 3);
        Fill2.fill(Adapter.collectionAdapter(petList), Cat.class, 2);
        for (Pet c : petList) {
            System.out.println(c);
        }
        System.out.println("----------------------");
        AddableSimpleQueue<Pet> petQueue = new AddableSimpleQueue<Pet>();
        Fill2.fill(petQueue, Cat.class, 4);
        Fill2.fill(petQueue, Dog.class, 1);
        for (Pet pet : petQueue) {
            System.out.println(pet);
        }
    }
}

interface Addable<T> {
    void add(T t);
}

class Fill2 {
    public static <T> void fill(Addable<T> addable, Class<? extends T> classToken, int size) {
        for (int i = 0; i < size; i++)
            try {
                addable.add(classToken.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    public static <T> void fill(Addable<T> addable, Generator<T> generator, int size) {
        for (int i = 0; i < size; i++)
            addable.add(generator.next());
    }
}

class AddableCollectionAdapter<T> implements Addable<T> {
    private Collection<T> c;

    public AddableCollectionAdapter(Collection<T> c) {
        this.c = c;
    }

    public void add(T item) {
        c.add(item);
    }
}

class Adapter {
    public static <T> Addable<T> collectionAdapter(Collection<T> c) {
        return new AddableCollectionAdapter<>(c);
    }
}

class AddableSimpleQueue<T>
        extends SimpleQueue<T> implements Addable<T> {
    public void add(T item) {
        super.add(item);
    }
}