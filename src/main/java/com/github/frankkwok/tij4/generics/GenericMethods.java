package com.github.frankkwok.tij4.generics;

/**
 * Page 472
 * Exercise 9: Modify GenericMethods.java so that f( ) accepts three arguments, all of which are of a different
 * parameterized type.
 * Exercise 10: Modify the previous exercise so that one of f( )’s arguments is non-parameterized.
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class GenericMethods {
    /*public <A, B, C> void f(A a, B b, C c) {
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());
        System.out.println(c.getClass().getName());
    }*/

    public void f(Object a, Object b, Object c) {
        System.out.println(a.getClass().getName());
        System.out.println(b.getClass().getName());
        System.out.println(c.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods gm = new GenericMethods();
        gm.f("", 1, 1.0);
        gm.f(1.0F, 'c', gm);
    }
}
