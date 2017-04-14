package com.github.frankkwok.tij4.innerclasses;

/**
 * Page 283
 * Exercise 23: Create an interface U with three methods. Create a class A with a method that produces a reference to a
 * U by building an anonymous inner class. Create a second class B that contains an array of U. B should have one method
 * that accepts and stores a reference to a U in the array, a second method that sets a reference in the array
 * (specified by the method argument) to null, and a third method that moves through the array and calls the methods in
 * U. In main( ), create a group of A objects and a single B. Fill the B with U references produced by the A objects.
 * Use the B to call back into all the A objects. Remove some of the U references from the B.
 *
 * @author Frank Kwok on 2017/4/14.
 */
public class InterfaceAndInnerClassTest {
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();

        B b = new B(10);
        b.add(a1.getU());
        b.add(a2.getU());
        b.add(a2.getU());
        b.add(a1.getU());
        b.through();
        b.set(1, a1.getU());
        b.through();
    }
}

interface U {
    void f();

    void g();

    void h();
}

class A {
    U getU() {
        return new U() {
            @Override
            public void f() {
                System.out.println("A.U.f()");
            }

            @Override
            public void g() {
                System.out.println("A.U.g()");
            }

            @Override
            public void h() {
                System.out.println("A.U.h()");
            }
        };
    }
}

class B {
    private U[] us;
    private int index;

    B(int length) {
        us = new U[length];
    }

    void add(U u) {
        if (index < us.length) {
            us[index++] = u;
        }
    }

    void set(int index, U u) {
        if (index < 0 || index >= this.index) {
            throw new IndexOutOfBoundsException();
        }
        us[index] = u;
    }

    void through() {
        for (U u : us) {
            if (u != null) {
                u.f();
                u.g();
                u.h();
            }
        }
    }
}