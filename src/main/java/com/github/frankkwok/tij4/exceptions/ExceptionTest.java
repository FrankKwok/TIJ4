package com.github.frankkwok.tij4.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Page 341
 * Exercise 1: Create a class with a main( ) that throws an object of class Exception inside a try block. Give the
 * constructor for Exception a String argument. Catch the exception inside a catch clause and print the String argument.
 * Add a finally clause and print a message to prove you were there.
 * Exercise 2: Define an object reference and initialize it to null. Try to call a method through this reference. Now
 * wrap the code in a try-catch clause to catch the exception.
 * Exercise 3: Write code to generate and catch an ArraylndexOutOfBoundsException.
 * Exercise 4: Create your own exception class using the extends keyword. Write a constructor for this class that takes
 * a String argument and stores it inside the object with a String reference. Write a method that displays the stored
 * String. Create a try-catch clause to exercise your new exception
 * <p>
 * Page 344
 * Exercise 6: Create two exception classes, each of which performs its own logging automatically. Demonstrate that
 * these work.
 * Exercise 7: Modify Exercise 3 so that the catch clause logs the results.
 * <p>
 * Page 373
 * Exercise 27: Modify Exercise 3 to convert the exception to a RuntimeException.
 * Exercise 28: Modify Exercise 4 so that the custom exception class inherits from RuntimeException, and show that the
 * compiler allows you to leave out the try block.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class ExceptionTest {
    private static Logger logger = Logger.getLogger(ExceptionTest.class.getName());

    public static void main(String[] args) {
        try {
            throw new Exception("in ExceptionTest.main()");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("In finally");
        }

        Object object = null;
        try {
            object.getClass();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        int[] ints = new int[0];
        try {
            System.out.println(ints[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
//            logException(e);
            throw new RuntimeException(e);
        }

        throw new FirstException();

        /*while (true) {
            try {
                System.out.println(object.getClass());
                break;
            } catch (Exception e) {
                e.printStackTrace();
                object = new Object();
            }
        }

        throw new SecondException("second", 5);*/
    }

    private static void logException(Exception e) {
        StringWriter trace = new StringWriter();
        e.printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

class FirstException extends RuntimeException {
    private String message;

    public FirstException() {
    }

    public FirstException(String message) {
        super(message);
        this.message = message;
    }

    public void display() {
        System.out.println(message);
    }
}

class SecondException extends RuntimeException {
    private int x;

    public SecondException(int x) {
        this.x = x;
    }

    public SecondException(String message, int x) {
        super(message);
        this.x = x;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + " x = " + x;
    }
}
