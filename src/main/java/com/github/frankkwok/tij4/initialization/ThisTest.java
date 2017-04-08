package com.github.frankkwok.tij4.initialization;

/**
 * Page 139
 * Exercise 8: Create a class with two methods. Within the first method, call the second method twice: the first time
 * without using this, and the second time using this—just to see it working; you should not use this form in practice.
 *
 * @author Frank Kwok on 2017/4/8.
 */
public class ThisTest {
    public static void main(String[] args) {
        ThisTest tt = new ThisTest();
        tt.first();
        tt.second();
    }

    private void first() {
        this.second();
        second();
    }

    private void second() {
        System.out.println("second");
    }
}
