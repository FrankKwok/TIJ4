package com.github.frankkwok.tij4.typoinfo.access;

/**
 * Page 457
 * Exercise 25: Create a class containing private, protected and package-access methods. Write code to access these
 * methods from outside of the class’s package.
 *
 * @author Frank Kwok on 2017/5/15.
 */
public class WithFields {
    private int i1 = 5;
    protected int i2 = 10;
    int i3 = 15;

    @Override
    public String toString() {
        return "WithFields{" +
                "i1=" + i1 +
                ", i2=" + i2 +
                ", i3=" + i3 +
                '}';
    }
}
