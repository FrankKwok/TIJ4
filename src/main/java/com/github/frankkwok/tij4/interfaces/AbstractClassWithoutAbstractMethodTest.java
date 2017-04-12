package com.github.frankkwok.tij4.interfaces;

/**
 * Page 244
 * Exercise 2: Create a class as abstract without including any abstract methods and verify that you cannot create any
 * instances of that class.
 *
 * @author Frank Kwok on 2017/4/12.
 */
public abstract class AbstractClassWithoutAbstractMethodTest {
    public static void main(String[] args) {
        // Error:(12, 9) java: com.github.frankkwok.tij4.interfaces.AbstractClassWithoutAbstractMethodTest是抽象的; 无法实例化
//        new AbstractClassWithoutAbstractMethodTest();
    }
}
