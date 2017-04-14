package com.github.frankkwok.tij4.innerclasses.innertest;

/**
 * Page 269
 * Exercise 5: Create a class with an inner class. In a separate class, make an instance of the inner class.
 *
 * @author Frank Kwok on 2017/4/13.
 */
public class InnerTest {
    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
    }
}

class Outer {
    class Inner {

    }
}
