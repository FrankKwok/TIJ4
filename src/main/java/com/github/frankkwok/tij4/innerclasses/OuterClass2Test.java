package com.github.frankkwok.tij4.innerclasses;

import com.github.frankkwok.tij4.innerclasses.interfacetest2.Interface2;

/**
 * Page 273
 * Exercise 11: Create a private inner class that implements a public interface. Write a method that returns a reference
 * to an instance of the private inner class, upcast to the interface. Show that the inner class is completely hidden by
 * trying to downcast to it.
 * <p>
 * Page 276
 * Exercise 13: Repeat Exercise 9 using an anonymous inner class.
 *
 * @author Frank Kwok on 2017/4/13.
 */
public class OuterClass2Test {
    public static void main(String[] args) {
        OuterClass2 oc2 = new OuterClass2();
        // private access
//        (OuterClass2.Inner3) oc2.getInner3();
        oc2.getInerface2().g();
    }
}
