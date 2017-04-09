package com.github.frankkwok.tij4.access;

/**
 * Page 180
 * Exercise 5: Create a class with public, private, protected, and package-access fields and method members. Create an
 * object of this class and see what kind of compiler messages you get when you try to access all the class members. Be
 * aware that classes in the same directory are part of the “default” package.
 *
 * @author Frank Kwok on 2017/4/9.
 */
public class AllAccess {
    public int a;
    protected int b;
    int c;
    private int d;

    public static void main(String[] args) {
        AllAccess aa = new AllAccess();
        System.out.println(aa.a);
        System.out.println(aa.b);
        System.out.println(aa.c);
        System.out.println(aa.d);

        aa.f();
        aa.g();
        aa.h();
        aa.i();
    }

    public void f() {
        System.out.println("f()");
    }

    protected void g() {
        System.out.println("g()");
    }

    void h() {
        System.out.println("h()");
    }

    private void i() {
        System.out.println("i()");
    }
}
