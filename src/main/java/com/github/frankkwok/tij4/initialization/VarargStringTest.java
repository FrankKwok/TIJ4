package com.github.frankkwok.tij4.initialization;

/**
 * Page 163
 * Exercise 19: Write a method that takes a vararg String array. Verify that you can pass either a comma-separated list
 * of Strings or a String[] into this method.
 * Exercise 20: Create a main( ) that uses varargs instead of the ordinary main( ) syntax. Print all the elements in the
 * resulting args array. Test it with various numbers of command-line arguments.
 *
 * @author Frank Kwok on 2017/4/8.
 */
public class VarargStringTest {
    public static void main(String... args) {
        take("hello, world");
        take("ghl", "frank", "kwok");

        for (String s : args) {
            System.out.print(s + " ");
        }
    }

    private static void take(String... args) {
        for (String s : args) {
            System.out.println(s);
        }
    }
}
