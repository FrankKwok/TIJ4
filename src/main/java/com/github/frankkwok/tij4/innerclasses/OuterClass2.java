package com.github.frankkwok.tij4.innerclasses;

import com.github.frankkwok.tij4.innerclasses.interfacetest2.Interface2;

/**
 * Page 272
 * Exercise 9: Create an interface with at least one method, and implement that interface by defining an inner class
 * within a method, which returns a reference to your interface.
 * <p>
 * Page 273
 * Exercise 10: Repeat the previous exercise but define the inner class within a scope within a method.
 * Exercise 11: Create a private inner class that implements a public interface. Write a method that returns a reference
 * to an instance of the private inner class, upcast to the interface. Show that the inner class is completely hidden by
 * trying to downcast to it.
 * <p>
 * Page 276
 * Exercise 13: Repeat Exercise 9 using an anonymous inner class.
 *
 * @author Frank Kwok on 2017/4/13.
 */
public class OuterClass2 {

    void defineInnerClass() {
        class Inner2 implements Interface2 {
            @Override
            public void g() {
                System.out.println("Define in method OuterClass2.Inner2.g()");
            }
        }
    }

    public Interface2 getInner3() {
        return new Inner3();
    }

    public Interface2 getInerface2() {
        return new Interface2() {
            @Override
            public void g() {
                System.out.println("this is an anonymous inner class");
            }
        };
    }

    class Inner1 implements Interface2 {
        @Override
        public void g() {
            System.out.println("OuterClass2.Inner1.g()");
        }
    }

    private class Inner3 implements Interface2 {
        @Override
        public void g() {
            System.out.println("Private inner class");
        }
    }
}
