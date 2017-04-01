package com.github.frankkwok.tij4.object;

/**
 * Page 61
 * <p>
 * Exercise 9: Write a program that demonstrates that autoboxing works for all the primitive types and their wrappers.
 *
 * @author Frank Kwok on 2017/4/1.
 */
public class AutoboxTest {
    public static void main(String[] args) {
        boolean b1 = true;
        Boolean b2 = b1;
        boolean b3 = b2;
        System.out.println("boolean-Boolean:");
        System.out.println("boolean b1: " + b1);
        System.out.println("Boolean b2: " + b2);
        System.out.println("boolean b3: " + b3);
        System.out.println();

        char c1 = 'b';
        Character c2 = c1;
        char c3 = c2;
        System.out.println("char-Character:");
        System.out.println("char c1: " + c1);
        System.out.println("Character c2: " + c2);
        System.out.println("char c3: " + c3);
        System.out.println();

        byte bt1 = 3;
        Byte bt2 = bt1;
        byte bt3 = bt2;
        System.out.println("byte-Byte:");
        System.out.println("byte bt1: " + bt1);
        System.out.println("Byte bt2: " + bt2);
        System.out.println("byte bt3: " + bt3);
        System.out.println();

        short s1 = 4;
        Short s2 = s1;
        short s3 = s2;
        System.out.println("short-Short:");
        System.out.println("short s1: " + s1);
        System.out.println("short s2: " + s2);
        System.out.println("short s3: " + s3);
        System.out.println();

        int i1 = 5;
        Integer i2 = i1;
        int i3 = i2;
        System.out.println("int-Integer:");
        System.out.println("int i1: " + i1);
        System.out.println("Integer i2: " + i2);
        System.out.println("int i3: " + i3);
        System.out.println();

        long l1 = 6;
        Long l2 = l1;
        long l3 = l2;
        System.out.println("long-Long:");
        System.out.println("long l1: " + l1);
        System.out.println("Long l2: " + l2);
        System.out.println("long l3: " + l3);
        System.out.println();

        float f1 = 7.0f;
        Float f2 = f1;
        float f3 = f2;
        System.out.println("float-Float:");
        System.out.println("float f1: " + f1);
        System.out.println("Float f2: " + f2);
        System.out.println("float f3: " + f3);
        System.out.println();

        double d1 = 8.0;
        Double d2 = d1;
        double d3 = d2;
        System.out.println("double-Double:");
        System.out.println("double d1: " + d1);
        System.out.println("Double d2: " + d2);
        System.out.println("double d3: " + d3);
        System.out.println();
    }
}
