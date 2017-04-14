package com.github.frankkwok.tij4.innerclasses;

import com.github.frankkwok.tij4.innerclasses.interfacetest.Interface;

/**
 * Page 271
 * Exercise 6: Create an interface with at least one method, in its own package. Create a class in a separate package.
 * Add a protected inner class that implements the interface. In a third package, inherit from your class and, inside a
 * method, return an object of the protected inner class, upcasting to the interface during the return.
 *
 * @author Frank Kwok on 2017/4/13.
 */
public class HasInterfaceInnerClass {
    protected class InterfaceImpl implements Interface {
        @Override
        public void f() {
            System.out.println("HasInterfaceInnerClass$InterfaceImpl.f()");
        }
    }
}
