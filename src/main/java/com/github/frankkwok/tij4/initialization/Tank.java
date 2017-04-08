package com.github.frankkwok.tij4.initialization;

/**
 * Page 144
 * Exercise 12: Create a class called Tank that can be filled and emptied, and has a termination condition that it must
 * be empty when the object is cleaned up. Write a finalize( ) that verifies this termination condition. In main( ),
 * test the possible scenarios that can occur when your Tank is used.
 *
 * @author Frank Kwok on 2017/4/8.
 */
public class Tank {
    private boolean empty;

    public static void main(String[] args) {
        new Tank();
        System.gc();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (!empty) {
            System.out.println("the tank is not empty");
        }
    }
}
