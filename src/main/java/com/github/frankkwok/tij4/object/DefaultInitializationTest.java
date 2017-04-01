package com.github.frankkwok.tij4.object;

/**
 * Page 61
 * <p>
 * Exercise 1: Create a class containing an int and a char that are not initialized, and print their values to
 * verify that Java performs default initialization.
 *
 * @author Frank Kwok on 2017/4/1.
 */
public class DefaultInitializationTest {
    private int i;
    private char c;

    public static void main(String[] args) {
        DefaultInitializationTest dit = new DefaultInitializationTest();
        System.out.println("int value: " + dit.i);
        System.out.println("char value: " + dit.c);

        dit.i = 1;
        dit.c = '2';
        System.out.println("int value: " + dit.i);
        System.out.println("char value: " + dit.c);
    }
}
