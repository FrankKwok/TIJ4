package com.github.frankkwok.tij4.reusing;

/**
 * Page 204
 * Exercise 16: Create a class called Amphibian. From this, inherit a class called Frog. Put appropriate methods in the
 * base class. In main( ), create a Frog and upcast it to Amphibian and demonstrate that all the methods still work.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class Frog extends Amphibian {
    public static void main(String[] args) {
        Amphibian amphibian = new Frog();
        amphibian.swim();
        amphibian.climb();
    }

    @Override
    void swim() {
        System.out.println("Frog.swim()");
        super.swim();
    }

    @Override
    void climb() {
        System.out.println("Frog.climb()");
        super.climb();
    }
}

class Amphibian {
    void swim() {
        System.out.println("Amphibian.swim()");
    }

    void climb() {
        System.out.println("Amphibian.climb()");
    }
}
