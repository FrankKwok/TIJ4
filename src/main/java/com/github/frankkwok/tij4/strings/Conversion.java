package com.github.frankkwok.tij4.strings;

import java.math.BigInteger;
import java.util.Formatter;

/**
 * Page 390
 * Exercise 5: For each of the basic conversion types in the above table, write the most complex formatting expression
 * possible. That is, use all the possible format specifiers available for that conversion type.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class Conversion {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);

        char u = 'a';
        System.out.println("u = 'a'");
        f.format("s: %1$-10.3s\n", u);
        // f.format("d: %d\n", u);
        f.format("c: %1$-10c\n", u);
        f.format("b: %1$-10.3b\n", u);
        // f.format("f: %f\n", u);
        // f.format("e: %e\n", u);
        // f.format("x: %x\n", u);
        f.format("h: %1$-10.3h\n", u);

        int v = 121;
        System.out.println("v = 121");
        f.format("d: %1$-10d\n", v);
        f.format("c: %1$-10c\n", v);
        f.format("b: %1$-10.3b\n", v);
        f.format("s: %1$-10.3s\n", v);
        // f.format("f: %f\n", v);
        // f.format("e: %e\n", v);
        f.format("x: %1$-10x\n", v);
        f.format("h: %1$-10.3h\n", v);

        BigInteger w = new BigInteger("50000000000000");
        System.out.println(
                "w = new BigInteger(\"50000000000000\")");
        f.format("d: %1$-10d\n", w);
        // f.format("c: %c\n", w);
        f.format("b: %1$-10.3b\n", w);
        f.format("s: %1$-10.3s\n", w);
        // f.format("f: %f\n", w);
        // f.format("e: %e\n", w);
        f.format("x: %1$-10x\n", w);
        f.format("h: %1$-10.3h\n", w);

        double x = 179.543;
        System.out.println("x = 179.543");
        // f.format("d: %d\n", x);
        // f.format("c: %c\n", x);
        f.format("b: %1$-10.3b\n", x);
        f.format("s: %1$-10.3s\n", x);
        f.format("f: %1$-10.3f\n", x);
        f.format("e: %1$-10.3e\n", x);
        // f.format("x: %x\n", x);
        f.format("h: %1$-10.3h\n", x);

        Conversion y = new Conversion();
        System.out.println("y = new Conversion()");
        // f.format("d: %d\n", y);
        // f.format("c: %c\n", y);
        f.format("b: %1$-10.3b\n", y);
        f.format("s: %1$-10.3s\n", y);
        // f.format("f: %f\n", y);
        // f.format("e: %e\n", y);
        // f.format("x: %x\n", y);
        f.format("h: %1$-10.3h\n", y);

        boolean z = false;
        System.out.println("z = false");
        // f.format("d: %d\n", z);
        // f.format("c: %c\n", z);
        f.format("b: %1$-10.3b\n", z);
        f.format("s: %1$-10.3s\n", z);
        // f.format("f: %f\n", z);
        // f.format("e: %e\n", z);
        // f.format("x: %x\n", z);
        f.format("h: %1$-10.3h\n", z);
    }
}
