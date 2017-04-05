package com.github.frankkwok.tij4.operators;

/**
 * Page 101
 * Exercise 12: Start with a number that is all binary ones. Left shift it, then use the unsigned right-shift operator
 * to right shift through all of its binary positions, each time displaying the result using Integer.toBinaryString( ).
 *
 * @author Frank Kwok on 2017/4/5.
 */
public class LURShiftTest {
    public static void main(String[] args) {
        int n = 0xffffffff;
        for (int i = 0; i < 32; i++) {
            System.out.println(n + "<<" + i + " = " + Integer.toBinaryString(n << i));
        }
        System.out.println();
        for (int i = 0; i < 32; i++) {
            System.out.println(n + ">>>" + i + " = " + Integer.toBinaryString(n >>> i));
        }
    }
}
