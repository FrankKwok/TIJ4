package com.github.frankkwok.tij4.innerclasses;

/**
 * Page 276
 * Exercise 15: Create a class with a non-default constructor (one with arguments) and no default constructor (no
 * "no-arg" constructor). Create a second class that has a method that returns a reference to an object of the first
 * class. Create the object that you return by making an anonymous inner class that inherits from the first class.
 *
 * @author Frank Kwok on 2017/4/13.
 */
public class NoDefaultConstructorTest {
    public static void main(String[] args) {
        NoDefaultConstructor ndc = getNoDefaultConstructor();
    }

    static NoDefaultConstructor getNoDefaultConstructor() {
        return new NoDefaultConstructor("hello, world") {

        };
    }
}

class NoDefaultConstructor {
    private String string;

    NoDefaultConstructor(String string) {
        System.out.println(string);
        this.string = string;
    }
}
