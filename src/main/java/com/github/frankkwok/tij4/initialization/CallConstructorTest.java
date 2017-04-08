package com.github.frankkwok.tij4.initialization;

/**
 * Page 141
 * Exercise 9: Create a class with two (overloaded) constructors. Using this, call the second constructor inside the
 * first one.
 *
 * @author Frank Kwok on 2017/4/8.
 */
public class CallConstructorTest {
    public static void main(String[] args) {
        new CallConstructorTest("hello");
    }

    private CallConstructorTest(String string) {
        this(string, 1);
    }

    private CallConstructorTest(String string, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(string + " " + i);
        }
    }
}
