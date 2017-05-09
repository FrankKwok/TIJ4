package com.github.frankkwok.tij4.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Page 366
 * Exercise 22: Create a class called FailingConstructor with a constructor that might fail partway through the
 * construction process and throw an exception. In main( ), write code that properly guards against this failure.
 * Exercise 23: Add a class with a dispose( ) method to the previous exercise. Modify FailingConstructor so that the
 * constructor creates one of these disposable objects as a member object, after which the constructor might throw an
 * exception, after which it creates a second disposable member object. Write code to properly guard against failure,
 * and in main( ) verify that all possible failure situations are covered.
 * Exercise 24: Add a dispose( ) method to the FailingConstructor class and write code to properly use this class.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class FailingConstructor {
    private WithDispose withDispose1;
    private WithDispose withDispose2;

    public FailingConstructor() throws FileNotFoundException {
        try {
            withDispose1 = new WithDispose();
            try {
                withDispose2 = new WithDispose();
            } catch (FileNotFoundException e) {
                throw e;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            FailingConstructor fc = new FailingConstructor();
        } catch (FileNotFoundException e) {
            System.out.println("FailingConstructor construction failed");
        }
    }

    public void dispose() {
        if (withDispose1 != null) {
            try {
                withDispose1.dispose();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (withDispose2 != null) {
                    try {
                        withDispose2.dispose();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class WithDispose {
    private BufferedReader br;

    public WithDispose() throws Exception {
        try {
            br = new BufferedReader(new FileReader("xxx"));
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file xxx");
            throw e;
        } catch (Exception e) {
            try {
                br.close();
            } catch (IOException e2) {
                System.out.println("br.close() unsuccessful");
            }
            throw e;
        }
    }

    public void dispose() {
        try {
            br.close();
            System.out.println("dispose() successful");
        } catch (IOException e) {
            throw new RuntimeException("in.close() failed");
        }
    }
}
