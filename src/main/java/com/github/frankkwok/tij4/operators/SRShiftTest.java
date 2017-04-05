package com.github.frankkwok.tij4.operators;

/**
 * Page 101
 * Exercise 11: Start with a number that has a binary one in the most significant position (hint: Use a hexadecimal
 * constant). Using the signed right-shift operator, right shift it all the way through all of its binary positions,
 * each time displaying the result using Integer.toBinaryString( ).
 *
 * @author Frank Kwok on 2017/4/5.
 */
public class SRShiftTest {
    public static void main(String[] args) {
        int n = 0x80000000;
        for (int i = 0; i < 32; i++) {
            System.out.println(n + ">>" + i + " = " + Integer.toBinaryString(n >> i));
        }
    }
}
