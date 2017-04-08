package com.github.frankkwok.tij4.initialization;

/**
 * Page 154
 * Exercise 14: Create a class with a static String field that is initialized at the point of definition, and another
 * one that is initialized by the static block. Add a static method that prints both fields and demonstrates that they
 * are both initialized before they are used.
 *
 * @author Frank Kwok on 2017/4/8.
 */
public class StaticStringTest {
    private static String string1 = "hello";
    private static String string2;

    static {
        string2 = "world";
    }

    public static void main(String[] args) {
        System.out.println(StaticStringTest.string1);
        System.out.println(StaticStringTest.string2);
    }
}
