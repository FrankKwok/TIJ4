package com.github.frankkwok.tij4.innerclasses;

/**
 * Page 291
 * Exercise 26: Create a class with an inner class that has a non-default constructor (one that takes arguments). Create
 * a second class with an inner class that inherits from the first inner class.
 *
 * @author Frank Kwok on 2017/4/14.
 */
public class InheritInnerClassTest extends InnerClassTest.InnerClass {
    public InheritInnerClassTest(InnerClassTest ict, String string) {
        ict.super(string);
    }

    public static void main(String[] args) {
        new InheritInnerClassTest(new InnerClassTest(), "hello, world");
    }
}

class InnerClassTest {
    class InnerClass {
        public InnerClass(String string) {
            System.out.println(string);
        }
    }
}
