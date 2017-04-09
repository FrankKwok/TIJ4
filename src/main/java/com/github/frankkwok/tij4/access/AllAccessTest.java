package com.github.frankkwok.tij4.access;

/**
 * Page 180
 * Exercise 5: Create a class with public, private, protected, and package-access fields and method members. Create an
 * object of this class and see what kind of compiler messages you get when you try to access all the class members. Be
 * aware that classes in the same directory are part of the “default” package.
 *
 * @author Frank Kwok on 2017/4/9.
 */
public class AllAccessTest {
    public static void main(String[] args) {
        AllAccess aa = new AllAccess();
        System.out.println(aa.a);
        System.out.println(aa.b);
        System.out.println(aa.c);
        // Error:(12, 30) java: d可以在com.github.frankkwok.tij4.access.AllAccess中访问private
//        System.out.println(aa.d);

        aa.f();
        aa.g();
        aa.h();
        // Error:(17, 11) java: i()可以在com.github.frankkwok.tij4.access.AllAccess中访问private
//        aa.i();
    }
}
