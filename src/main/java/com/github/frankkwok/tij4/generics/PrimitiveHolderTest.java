package com.github.frankkwok.tij4.generics;

/**
 * Page 517
 * Exercise 30: Create a Holder for each of the primitive wrapper types, and show that autoboxing and autounboxing works
 * for the set( ) and get( ) methods of each instance.
 *
 * @author Frank Kwok on 2017/5/17.
 */
public class PrimitiveHolderTest {
    public static void main(String[] args) {
        Holder<Boolean> booleanHolder = new Holder<>(true);
        boolean b = booleanHolder.get();
        System.out.println(b);

        Holder<Character> characterHolder = new Holder<>('c');
        char c = characterHolder.get();
        System.out.println(c);


        Holder<Byte> byteHolder = new Holder<>((byte) 1);
        byte bt = byteHolder.get();
        System.out.println(bt);

        Holder<Short> shortHolder = new Holder<>((short)2);
        short s = shortHolder.get();
        System.out.println(s);

        Holder<Integer> integerHolder = new Holder<>(3);
        int i = integerHolder.get();
        System.out.println(i);

        Holder<Long> longHolder = new Holder<>(4L);
        long l = longHolder.get();
        System.out.println(l);

        Holder<Float> floatHolder = new Holder<>(5.0f);
        float f = floatHolder.get();
        System.out.println(f);

        Holder<Double> doubleHolder = new Holder<>(6.0);
        double d = doubleHolder.get();
        System.out.println(d);
    }
}
