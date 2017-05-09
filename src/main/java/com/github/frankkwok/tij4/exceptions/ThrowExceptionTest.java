package com.github.frankkwok.tij4.exceptions;

/**
 * Page 345
 * Exercise 8: Write a class with a method that throws an exception of the type created in Exercise 4. Try compiling it
 * without an exception specification to see what the compiler says. Add the appropriate exception specification. Try
 * out your class and its exception inside a try-catch clause.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class ThrowExceptionTest {
    public static void main(String[] args) {
        try {
            exceptionTest();
        } catch (FirstException e) {
            e.printStackTrace();
        }
    }

    private static void exceptionTest() throws FirstException {
        throw new FirstException();
    }
}
