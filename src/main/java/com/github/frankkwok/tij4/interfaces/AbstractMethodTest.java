package com.github.frankkwok.tij4.interfaces;

/**
 * Page 244
 * Exercise 4: Create an abstract class with no methods. Derive a class and add a method. Create a static method that
 * takes a reference to the base class, downcasts it to the derived class, and calls the method. In main( ), demonstrate
 * that it works. Now put the abstract declaration for the method in the base class, thus eliminating the need for the
 * downcast.
 *
 * @author Frank Kwok on 2017/4/12.
 */
public class AbstractMethodTest extends AbstractMethod {
    public static void main(String[] args) {
        AbstractMethod amt = new AbstractMethodTest();
//        ((AbstractMethodTest) amt).print();
        amt.print();
    }

    @Override
    void print() {
        System.out.println("AbstractMethodTest.print()");
    }
}

abstract class AbstractMethod {
    abstract void print();
}
