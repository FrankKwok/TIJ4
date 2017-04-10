package com.github.frankkwok.tij4.reusing;

/**
 * Page 200
 * Exercise 13: Create a class with a method that is overloaded three times. Inherit a new class, add a new overloading
 * of the method, and show that all four methods are available in the derived class.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class OverrideTest extends OverrideBase {
    public static void main(String[] args) {
        OverrideTest ot = new OverrideTest();
        ot.f();
        ot.f(1);
        ot.f("11");
        ot.f(111f);
    }

    void f(float f) {
        System.out.println("f(" + f + ")");
    }
}

class OverrideBase {
    void f() {
        System.out.println("f()");
    }

    void f(int i) {
        System.out.println("f(" + i + ")");
    }

    void f(String s) {
        System.out.println("f(" + s + ")");
    }
}
