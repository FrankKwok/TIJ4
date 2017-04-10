package com.github.frankkwok.tij4.reusing;

/**
 * Page 212
 * Exercise 24: In Beetle.java, inherit a specific type of beetle from class Beetle, following the same format as the
 * existing classes. Trace and explain the output.
 *
 * @author Frank Kwok on 2017/4/10.
 */
public class BeetleTest extends Beetle {
    private int l = printInit("BeetleTest.l initialized");

    private static int x3 = printInit("static BeetleTest.x3 initialized");

    BeetleTest() {
        System.out.println("l = " + l);
    }

    public static void main(String[] args) {
        printInit("BeetleTest constructor");
        BeetleTest bt = new BeetleTest();
    }
}

class Insect {
    private int i = 9;
    protected int j;

    Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 =
            printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

class Beetle extends Insect {
    private int k = printInit("Beetle.k initialized");

    Beetle() {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    private static int x2 =
            printInit("static Beetle.x2 initialized");
}
