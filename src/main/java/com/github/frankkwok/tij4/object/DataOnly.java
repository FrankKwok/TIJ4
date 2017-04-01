package com.github.frankkwok.tij4.object;

/**
 * Page 61
 * <p>
 * Exercise 4: Turn the DataOnly code fragments into a program that compiles and runs.
 * Exercise 5: Modify the previous exercise so that the values of the data in DataOnly are assigned to and printed in
 * main( ).
 *
 * @author Frank Kwok on 2017/4/1.
 */
public class DataOnly {
    private int i;
    private double d;
    private boolean b;

    public static void main(String[] args) {
        DataOnly da = new DataOnly();
        System.out.println("da.i = " + da.i);
        System.out.println("da.d = " + da.d);
        System.out.println("da.b = " + da.b);

        da.i = 1;
        da.d = 2;
        da.b = true;
        System.out.println("da.i = " + da.i);
        System.out.println("da.d = " + da.d);
        System.out.println("da.b = " + da.b);
    }
}
