package com.github.frankkwok.tij4.exceptions;

/**
 * Page 346
 * Exercise 9: Create three new types of exceptions. Write a class with a method that throws all three. In main( ), call
 * the method but only use a single catch clause that will catch all three types of exceptions.
 * <p>
 * Page 357
 * Exercise 13: Modify Exercise 9 by adding a finally clause. Verify that your finally clause is executed, even if a
 * NullPointerException is thrown.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class CatchExceptionsTest {
    public static void main(String[] args) {
        try {
            throwAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally 1");
        }

        try {
            throwAll();
        } catch (Exception1 | Exception2 | Exception3 e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally 2");
        }

        try {
            throw new NullPointerException();
        } finally {
            System.out.println("finally 3");
        }
    }

    private static void throwAll() throws Exception1, Exception2, Exception3 {
        double v = Math.random();
        if (v < 0.3) {
            throw new Exception1();
        } else if (v < 0.6) {
            throw new Exception2();
        } else if (v < 0.9) {
            throw new Exception3();
        }
    }
}

class Exception1 extends Exception {
    public Exception1() {
    }
}

class Exception2 extends Exception {
    public Exception2() {
    }
}

class Exception3 extends Exception {
    public Exception3() {
    }
}
