package com.github.frankkwok.tij4.reusing;

/**
 * Page 193
 * Exercise 8: Create a base class with only a non-default constructor, and a derived class with both a default (no-arg)
 * and non-default constructor. In the derived-class constructors, call the base-class constructor.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class CallBaseClassConstructorTest extends BaseClassWithNoDefaultConstructor {
    CallBaseClassConstructorTest(String s) {
        super(s);
    }

    CallBaseClassConstructorTest() {
        super("CallBaseClassConstructorTest");
    }

    public static void main(String[] args) {
        CallBaseClassConstructorTest t1 = new CallBaseClassConstructorTest();
        CallBaseClassConstructorTest t2 = new CallBaseClassConstructorTest("t2");
    }
}

class BaseClassWithNoDefaultConstructor {
    BaseClassWithNoDefaultConstructor(String s) {
        System.out.println(s);
    }
}
