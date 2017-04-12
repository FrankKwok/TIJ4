package com.github.frankkwok.tij4.interfaces;

/**
 * Page 244
 * Exercise 3: Create a base class with an abstract print( ) method that is overridden in a derived class. The
 * overridden version of the method prints the value of an int variable defined in the derived class. At the point of
 * definition of this variable, give it a nonzero value. In the base-class constructor, call this method. In main( ),
 * create an object of the derived type, and then call its print( ) method. Explain the results.
 * <p>
 * when super class call print, the field i is not initialized
 *
 * @author Frank Kwok on 2017/4/12.
 */
public class AbstractPrintTest extends AbstractPrint {
    private int i = 45;

    public static void main(String[] args) {
        AbstractPrint apt = new AbstractPrintTest();
        apt.print();
    }

    @Override
    void print() {
        System.out.println("i = " + i);
    }
}

abstract class AbstractPrint {
    AbstractPrint() {
        print();
    }

    abstract void print();
}
