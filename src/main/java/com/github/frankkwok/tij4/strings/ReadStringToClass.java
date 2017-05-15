package com.github.frankkwok.tij4.strings;

import java.util.Scanner;

/**
 * Page 410
 * Exercise 20: Create a class that contains int, long, float and double and String fields. Create a constructor for
 * this class that takes a single String argument, and scans that string into the various fields. Add a toString( )
 * method and demonstrate that your class works correctly.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class ReadStringToClass {
    int i;
    long l;
    float f;
    double d;
    String s;

    public ReadStringToClass(String text) {
        Scanner scanner = new Scanner(text);
        i = scanner.nextInt();
        l = scanner.nextLong();
        f = scanner.nextFloat();
        d = scanner.nextDouble();
        s = scanner.next();
    }

    public static void main(String[] args) {
        ReadStringToClass r = new ReadStringToClass("1 2 3.0 4.0 frank");
        System.out.println(r);
    }

    @Override
    public String toString() {
        return "ReadStringToClass{" +
                "i=" + i +
                ", l=" + l +
                ", f=" + f +
                ", d=" + d +
                ", s='" + s + '\'' +
                '}';
    }
}
