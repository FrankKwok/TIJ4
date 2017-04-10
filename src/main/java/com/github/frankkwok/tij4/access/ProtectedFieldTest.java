package com.github.frankkwok.tij4.access;

/**
 * Page 180
 * Exercise 6: Create a class with protected data. Create a second class in the same file with a method that manipulates
 * the protected data in the first class.
 *
 * @author Frank Kwok on 2017/4/9.
 */
public class ProtectedFieldTest {
    public static void main(String[] args) {
        ProtectedField pf = new ProtectedField();
        System.out.println(pf.i);
        pf.i = 45;
        System.out.println(pf.i);
    }
}

class ProtectedField {
    protected int i;
}
