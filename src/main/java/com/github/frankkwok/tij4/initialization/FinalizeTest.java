package com.github.frankkwok.tij4.initialization;

/**
 * Page 144
 * Exercise 10: Create a class with a finalize( ) method that prints a message. In main( ), create an object of your
 * class. Explain the behavior of your program.
 * Exercise 11: Modify the previous exercise so that your finalize( ) will always be called.
 *
 * @author Frank Kwok on 2017/4/8.
 */
public class FinalizeTest {
    public static void main(String[] args) {
        new FinalizeTest();
        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("invoke finalize");
    }
}
