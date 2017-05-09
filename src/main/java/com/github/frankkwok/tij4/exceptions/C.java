package com.github.frankkwok.tij4.exceptions;

/**
 * Page 367
 * Exercise 25: Create a three-level hierarchy of exceptions. Now create a base-class A with a method that throws an
 * exception at the base of your hierarchy. Inherit B from A and override the method so it throws an exception at level
 * two of your hierarchy. Repeat by inheriting class C from B. In main( ), create a C and upcast it to A, then call the
 * method.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class C extends B {
    public static void main(String[] args) {
        C c = new C();
        try {
            c.throwException();
        } catch (Exec3 exec3) {
            exec3.printStackTrace();
        }
    }

    @Override
    void throwException() throws Exec3 {
        try {
            super.throwException();
        } catch (Exec2 exec2) {
            exec2.printStackTrace();
        }
        System.out.println("C.throwException");
        throw new Exec3();
    }
}

class A {
    void throwException() throws Exec1 {
        System.out.println("A.throwException");
        throw new Exec1();
    }
}

class B extends A {
    @Override
    void throwException() throws Exec2 {
        try {
            super.throwException();
        } catch (Exec1 exec1) {
            exec1.printStackTrace();
        }
        System.out.println("B.throwException");
        throw new Exec2();
    }
}

class Exec1 extends Exception {

}

class Exec2 extends Exec1 {

}

class Exec3 extends Exec2 {

}
