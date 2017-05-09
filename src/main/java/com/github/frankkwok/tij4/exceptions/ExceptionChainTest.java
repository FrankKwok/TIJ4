package com.github.frankkwok.tij4.exceptions;

/**
 * Page 352
 * Exercise 10: Create a class with two methods, f( ) and g( ). In g( ), throw an exception of a new type that you
 * define. In f( ), call g( ), catch its exception and, in the catch clause, throw a different exception (of a second
 * type that you define). Test your code in main( ).
 * Exercise 11: Repeat the previous exercise, but inside the catch clause, wrap g( )’s exception in a RuntimeException.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class ExceptionChainTest {
    public static void main(String[] args) {
        e();
    }

    static void e() {
        try {
            f();
        } catch (Exception2 e) {
            throw new RuntimeException(e);
        }
    }

    static void f() throws Exception2 {
        try {
            g();
        } catch (Exception1 e) {
            Exception2 e2 = new Exception2();
            e2.initCause(e);
            throw e2;
        }
    }

    static void g() throws Exception1 {
        throw new Exception1();
    }
}
