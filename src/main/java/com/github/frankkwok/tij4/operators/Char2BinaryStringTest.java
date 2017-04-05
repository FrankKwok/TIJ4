package com.github.frankkwok.tij4.operators;

/**
 * Page 101
 * Exercise 13: Write a method that displays char values in binary form. Demonstrate it using several different
 * characters.
 *
 * @author Frank Kwok on 2017/4/5.
 */
public class Char2BinaryStringTest {
    public static void main(String[] args) {
        System.out.println("c.toBinaryString: " + char2BinaryString('c'));
        System.out.println("x.toBinaryString: " + char2BinaryString('x'));
    }

    private static String char2BinaryString(char c) {
        return Integer.toBinaryString(c);
    }
}
