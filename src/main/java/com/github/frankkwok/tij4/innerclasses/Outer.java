package com.github.frankkwok.tij4.innerclasses;

/**
 * Page 266
 * Exercise 1: Write a class named Outer that contains an inner class named Inner. Add a method to Outer that returns an
 * object of type Inner. In main( ), create and initialize a reference to an Inner.
 * <p>
 * Page 268
 * Exercise 3: Modify Exercise 1 so that Outer has a private String field (initialized by the constructor), and Inner
 * has a toString( ) that displays this field. Create an object of type Inner and display it.
 *
 * @author Frank Kwok on 2017/4/13.
 */
public class Outer {
    private String string;

    public Outer(String string) {
        this.string = string;
    }

    public static void main(String[] args) {
        Outer.Inner inner = new Outer("hello, world").inner();
        System.out.println(inner);
    }

    Inner inner() {
        return new Inner();
    }

    private class Inner {
        @Override
        public String toString() {
            return string;
        }
    }
}
