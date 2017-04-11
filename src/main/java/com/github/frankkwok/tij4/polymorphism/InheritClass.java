package com.github.frankkwok.tij4.polymorphism;

/**
 * Page 224
 * Exercise 10: Create a base class with two methods. In the first method, call the second method. Inherit a class and
 * override the second method. Create an object of the derived class, upcast it to the base type, and call the first
 * method. Explain what happens.
 * <p>
 * 模板方法-template method
 *
 * @author Frank Kwok on 2017/4/11.
 */
public class InheritClass extends BaseClass {
    public static void main(String[] args) {
        BaseClass bc = new InheritClass();
        bc.first();
    }

    @Override
    void second() {
        System.out.println("InheritClass.second()");
    }
}

class BaseClass {
    void first() {
        second();
    }

    void second() {
        System.out.println("BaseClass.second()");
    }
}
