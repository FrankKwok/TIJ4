package com.github.frankkwok.tij4.reusing;

import com.github.frankkwok.tij4.reusing.protectedtest.ProtectedMethod;

/**
 * Page 202
 * Exercise 15: Create a class inside a package. Your class should contain a protected method. Outside of the package,
 * try to call the protected method and explain the results. Now inherit from your class and call the protected method
 * from inside a method of your derived class.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class ProtectedTest extends ProtectedMethod {
    public static void main(String[] args) {
        ProtectedMethod pm = new ProtectedMethod();
        // Error:(16, 11) java: f()可以在com.github.frankkwok.tij4.reusing.protectedtest.ProtectedMethod中访问protected
//        pm.f();
        ProtectedTest pt = new ProtectedTest();
        pt.f();
        pt.g();
    }

    void g() {
        System.out.println("g()");
        f();
    }
}
