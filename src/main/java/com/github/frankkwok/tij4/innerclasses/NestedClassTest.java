package com.github.frankkwok.tij4.innerclasses;

/**
 * Page 279
 * Exercise 18: Create a class containing a nested class. In main( ), create an instance of the nested class.
 *
 * @author Frank Kwok on 2017/4/14.
 */
public class NestedClassTest {
    public static void main(String[] args) {
        NestedClassTest.NestedClass nc = new NestedClassTest.NestedClass();
        nc.print();
    }

    static class NestedClass {
        void print() {
            System.out.println("NestedClassTest$NestedClass.print()");
        }
    }
}
