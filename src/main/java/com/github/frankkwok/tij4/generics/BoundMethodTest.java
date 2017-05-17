package com.github.frankkwok.tij4.generics;

/**
 * Page 504
 * Exercise 25: Create two interfaces and a class that implements both. Create two generic methods, one whose argument
 * parameter is bounded by the first interface and one whose argument parameter is bounded by the second interface.
 * Create an instance of the class that implements both interfaces, and show that it can be used with both generic
 * methods.
 *
 * @author Frank Kwok on 2017/5/17.
 */
public class BoundMethodTest {
    public static void main(String[] args) {
        Bound bound = new Bound();
        f(bound);
        g(bound);
    }

    static <T extends Bound1> void f(T t) {

    }

    static <T extends Bound2> void g(T t) {

    }
}

interface Bound1 {

}

interface Bound2 {

}

class Bound implements Bound1, Bound2 {

}
