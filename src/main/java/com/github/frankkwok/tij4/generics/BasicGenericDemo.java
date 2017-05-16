package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.util.Generator;

/**
 * Page 477
 * Exercise 14: Modify BasicGeneratorDemo.java to use the explicit form of creation for the Generator (that is, use the
 * explicit constructor instead of the generic create( ) method).
 * <p>
 * Use lambda expression and constructor reference instead.
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class BasicGenericDemo {
    public static void main(String[] args) {
        Generator<CountedObject> gen = CountedObject::new;
        for (int i = 0; i < 10; i++) {
            System.out.println(gen.next());
        }
    }
}

class CountedObject {
    private static long counter = 0;
    private final long id = counter++;

    public long id() {
        return id;
    }

    public String toString() {
        return "CountedObject " + id;
    }
}
