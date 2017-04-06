package com.github.frankkwok.tij4.control;

/**
 * Page 118
 * Exercise 5: Repeat Exercise 10 from the previous chapter, using the ternary operator and a bitwise test to display
 * the ones and zeroes, instead of Integer.toBinaryString( ).
 *
 * @author Frank Kwok on 2017/4/6.
 */
public class Integer2BinaryString {
    public static void main(String[] args) {
        int a = 0xaaaaaaaa;
        int b = 0x55555555;
        System.out.print("a = ");
        printBinary(a);
        System.out.print("b = ");
        printBinary(b);
        System.out.print("a&b = ");
        printBinary(a & b);
        System.out.print("a|b = ");
        printBinary(a | b);
        System.out.print("a^b = ");
        printBinary(a ^ b);
        System.out.print("~a = ");
        printBinary(~a);
        System.out.print("~b = ");
        printBinary(~b);
    }

    private static void printBinary(int number) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((number & pow2(i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    private static int pow2(int x) {
        int y = 1;
        for (int i = 0; i < x; i++) {
            y *= 2;
        }
        return y;
    }
}
