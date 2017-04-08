package com.github.frankkwok.tij4.initialization;

/**
 * Page 155
 * Exercise 15: Create a class with a String that is initialized using instance initialization.
 *
 * @author Frank Kwok on 2017/4/8.
 */
public class InstanceInitializationTest {
    private String string;

    {
        string="hello, world";
    }

    public static void main(String[] args) {
        InstanceInitializationTest iit = new InstanceInitializationTest();
        System.out.println(iit.string);
    }
}
