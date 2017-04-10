package com.github.frankkwok.tij4.reusing.protectedtest;

/**
 * Page 202
 * Exercise 15: Create a class inside a package. Your class should contain a protected method. Outside of the package,
 * try to call the protected method and explain the results. Now inherit from your class and call the protected method
 * from inside a method of your derived class.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class ProtectedMethod {
    protected void f() {
        System.out.println("protected f()");
    }
}
