package com.github.frankkwok.tij4.access;

/**
 * Page 180
 * Exercise 4: Show that protected methods have package access but are not public.
 *
 * @author Frank Kwok on 2017/4/9.
 */
public class ProtectedTest {
    public static void main(String[] args) {
        Protected p = new Protected();
        p.test();
    }
}
