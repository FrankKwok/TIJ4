package com.github.frankkwok.tij4.innerclasses;

/**
 * Page 280
 * Exercise 20: Create an interface containing a nested class. Implement this interface and create an instance of the
 * nested class.
 * Exercise 21: Create an interface that contains a nested class that has a static method that calls the methods of your
 * interface and displays the results. Implement your interface and pass an instance of your implementation to the
 * method.
 *
 * @author Frank Kwok on 2017/4/14.
 */
public class InterfaceContainClassTest implements ContainClass {
    public static void main(String[] args) {
        NestedClass nc = new NestedClass();
        NestedClass.innerF(new InterfaceContainClassTest());
    }

    @Override
    public void f() {
        System.out.println("InterfaceContainClassTest.f()");
    }
}

interface ContainClass {
    void f();

    class NestedClass {
        static void innerF(ContainClass cc) {
            cc.f();
        }
    }
}
