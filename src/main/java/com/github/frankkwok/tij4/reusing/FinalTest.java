package com.github.frankkwok.tij4.reusing;

/**
 * Page 206
 * Exercise 18: Create a class with a static final field and a final field and demonstrate the difference between the two.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class FinalTest {
    private static final int INT = 100;
    private final int i;

    FinalTest() {
        i = (int) (Math.random() * INT);
    }

    public static void main(String[] args) {
        System.out.println("static final int: " + FinalTest.INT);
        System.out.println("final int: " + new FinalTest().i);
        System.out.println("final int: " + new FinalTest().i);
    }
}
