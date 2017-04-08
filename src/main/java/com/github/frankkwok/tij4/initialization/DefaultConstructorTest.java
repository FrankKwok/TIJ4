package com.github.frankkwok.tij4.initialization;

/**
 * Page 137
 * Exercise 3: Create a class with a default constructor (one that takes no arguments) that prints a message. Create an
 * object of this class.
 * Exercise 4: Add an overloaded constructor to the previous exercise that takes a String argument and prints it along
 * with your message.
 *
 * @author Frank Kwok on 2017/4/8.
 */
public class DefaultConstructorTest {
    private DefaultConstructorTest() {
        System.out.println("Create DefaultConstructorTest");
    }

    private DefaultConstructorTest(String string) {
        System.out.println("Print " + string);
    }

    public static void main(String[] args) {
        new DefaultConstructorTest();
        new DefaultConstructorTest("hello, world");
    }
}
