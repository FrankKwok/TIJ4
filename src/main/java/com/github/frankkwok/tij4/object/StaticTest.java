package com.github.frankkwok.tij4.object;

/**
 * Page 61
 * <p>
 * Exercise 7: Turn the Incrementable code fragments into a working program.
 * Exercise 8: Write a program that demonstrates that, no matter how many objects you create of a particular class,
 * there is only one instance of a particular static field in that class.
 *
 * @author Frank Kwok on 2017/4/1.
 */
public class StaticTest {
    static int i = 47;

    public static void main(String[] args) {
        StaticTest st1 = new StaticTest();
        StaticTest st2 = new StaticTest();
        System.out.println("Default value: ");
        System.out.println("StaticTest.i = " + StaticTest.i);
        System.out.println("st1.i = " + st1.i);
        System.out.println("st2.i = " + st2.i);
        System.out.println();

        Incrementable.increment();
        System.out.println("Increment 1");
        System.out.println("StaticTest.i = " + StaticTest.i);
        System.out.println("st1.i = " + st1.i);
        System.out.println("st2.i = " + st2.i);
        System.out.println();

        StaticTest.i = 32;
        System.out.println("Change to 32");
        System.out.println("StaticTest.i = " + StaticTest.i);
        System.out.println("st1.i = " + st1.i);
        System.out.println("st2.i = " + st2.i);
        System.out.println();

        st1.i = 16;
        System.out.println("Change to 16");
        System.out.println("StaticTest.i = " + StaticTest.i);
        System.out.println("st1.i = " + st1.i);
        System.out.println("st2.i = " + st2.i);
    }
}

class Incrementable {
    static void increment() {
        StaticTest.i++;
    }
}
