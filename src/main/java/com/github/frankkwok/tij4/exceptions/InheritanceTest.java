package com.github.frankkwok.tij4.exceptions;

import java.io.FileNotFoundException;

/**
 * Page 366
 * Exercise 21: Demonstrate that a derived-class constructor cannot catch exceptions thrown by its base-class
 * constructor.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class InheritanceTest {
}

class Base {
    Base() throws FileNotFoundException {

    }
}

class Derived extends Base {
    public Derived() throws FileNotFoundException {
        /*try {
            super();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
    }
}
