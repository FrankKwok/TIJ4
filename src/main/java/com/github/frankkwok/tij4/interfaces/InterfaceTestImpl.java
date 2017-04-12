package com.github.frankkwok.tij4.interfaces;

import com.github.frankkwok.tij4.interfaces.interfacetest.InterfaceTest;

/**
 * Page 247
 * Exercise 5: Create an interface containing three methods, in its own package. Implement the interface in a different
 * package.
 * Exercise 6: Prove that all the methods in an interface are automatically public.
 *
 * @author Frank Kwok on 2017/4/12.
 */
public class InterfaceTestImpl implements InterfaceTest {
    public static void main(String[] args) {
        InterfaceTest it = new InterfaceTestImpl();
        it.f();
        it.g();
        it.h();
    }

    @Override
    public void f() {
        System.out.println("InterfaceTestImpl.f()");
    }

    @Override
    public void g() {
        System.out.println("InterfaceTestImpl.g()");
    }

    @Override
    public void h() {
        System.out.println("InterfaceTestImpl.h()");
    }
}
