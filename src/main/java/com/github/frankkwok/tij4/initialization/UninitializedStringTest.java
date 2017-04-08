package com.github.frankkwok.tij4.initialization;

/**
 * Page 131
 * Exercise 1: Create a class containing an uninitialized String reference. Demonstrate that this reference is
 * initialized by Java to null.
 *
 * @author Frank Kwok on 2017/4/8.
 */
public class UninitializedStringTest {
    private String string;

    public static void main(String[] args) {
        UninitializedStringTest ust = new UninitializedStringTest();
        System.out.println("ust.string == null: " + (ust.string == null));
    }
}
