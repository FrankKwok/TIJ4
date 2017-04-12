package com.github.frankkwok.tij4.interfaces.interfaceprocessor;

/**
 * Page 251
 * Exercise 11: Create a class with a method that takes a String argument and produces a result that swaps each pair of
 * characters in that argument. Adapt the class so that it works with interfaceprocessor.Apply.process( ).
 *
 * @author Frank Kwok on 2017/4/12.
 */
class Apply {
    static void process(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
}
