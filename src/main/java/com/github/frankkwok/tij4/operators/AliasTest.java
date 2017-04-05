package com.github.frankkwok.tij4.operators;

/**
 * Page 88
 * Exercise 2: Create a class containing a float and use it to demonstrate aliasing.
 * <p>
 * Page 89
 * Exercise 3: Create a class containing a float and use it to demonstrate aliasing during method calls.
 *
 * @author Frank Kwok on 2017/4/5.
 */
public class AliasTest {
    public static void main(String[] args) {
        System.out.println("demonstrate aliasing:");
        FloatContainer fc1 = new FloatContainer();
        FloatContainer fc2 = new FloatContainer();
        fc1.f = 1.2f;
        fc2.f = 3.4f;
        System.out.println("1: fc1.f: " + fc1.f + ", fc2.f: " + fc2.f);
        fc1 = fc2;
        System.out.println("2: fc1.f: " + fc1.f + ", fc2.f: " + fc2.f);
        fc1.f = 5.6f;
        System.out.println("3: fc1.f: " + fc1.f + ", fc2.f: " + fc2.f);

        System.out.println("demonstrate aliasing during method calls");
        changeFloat(fc1);
        System.out.println("3: fc1.f: " + fc1.f + ", fc2.f: " + fc2.f);
    }

    private static void changeFloat(FloatContainer fc) {
        fc.f = 7.8f;
    }
}

class FloatContainer {
    float f;
}
