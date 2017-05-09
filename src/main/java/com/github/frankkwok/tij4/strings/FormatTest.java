package com.github.frankkwok.tij4.strings;

/**
 * Page 391
 * Exercise 6: Create a class that contains int, long, float and double fields. Create a toString( ) method for this
 * class that uses String.format( ), and demonstrate that your class works correctly.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class FormatTest {
    private int i;
    private long l;
    private float f;
    private double d;

    public FormatTest() {
        i = 1;
        l = 2;
        f = 3.3f;
        d = 4.4;
    }

    public FormatTest(int i, long l, float f, double d) {
        this.i = i;
        this.l = l;
        this.f = f;
        this.d = d;
    }

    public static void main(String[] args) {
        FormatTest ft = new FormatTest();
        System.out.println(ft);
    }

    @Override
    public String toString() {
        return String.format("i = %5d, l = %10d, f = %10.2f, d = %10.2f", i, l, f, d);
    }
}
