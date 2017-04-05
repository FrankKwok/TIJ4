package com.github.frankkwok.tij4.operators;

/**
 * Page 96
 * <p>
 * Exercise 8: Show that hex and octal notations work with long values. Use Long.toBinaryString( ) to display the results.
 *
 * @author Frank Kwok on 2017/4/5.
 */
public class Long2BinaryStringTest {
    public static void main(String[] args) {
        System.out.println("number 0xffffff = "+Long.toBinaryString(0xffffff));
        System.out.println("number 0777777 = "+Long.toBinaryString(0777777));
    }
}
