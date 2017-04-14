package com.github.frankkwok.tij4.innerclasses.returninterfacetest;

import com.github.frankkwok.tij4.innerclasses.HasInterfaceInnerClass;
import com.github.frankkwok.tij4.innerclasses.interfacetest.Interface;

/**
 * Page 271
 * Exercise 6: Create an interface with at least one method, in its own package. Create a class in a separate package.
 * Add a protected inner class that implements the interface. In a third package, inherit from your class and, inside a
 * method, return an object of the protected inner class, upcasting to the interface during the return.
 *
 * @author Frank Kwok on 2017/4/13.
 */
public class ReturnInterfaceTest extends HasInterfaceInnerClass {
    // 无法访问protected内部类
    /*Interface getInterface() {
        return new InterfaceImpl();
    }*/
}
