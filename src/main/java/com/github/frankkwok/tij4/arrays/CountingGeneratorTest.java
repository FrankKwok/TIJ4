package com.github.frankkwok.tij4.arrays;

import com.github.frankkwok.tij4.util.CountingGenerator;

import java.util.Arrays;

/**
 * Page 576
 * Exercise 12: Create an initialized array of double using CountingGenerator. Print the results.
 * Exercise 13: Fill a String using CountingGenerator.Character.
 * Exercise 14: Create an array of each primitive type, then fill each array by using CountingGenerator. Print each array.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class CountingGeneratorTest {
    public static void main(String[] args) {
        double[] doubles = new double[6];
        CountingGenerator.Double gen = new CountingGenerator.Double();
        for (int i = 0; i < doubles.length; i++) {
            doubles[i] = gen.next();
        }
        System.out.println(Arrays.toString(doubles));

        CountingGenerator.Character charGen = new CountingGenerator.Character();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(charGen.next());
        }
        System.out.println(sb.toString());

        CountingGenerator.Boolean boolGen = new CountingGenerator.Boolean();
        boolean[] booleans = new boolean[5];
        for (int i = 0; i < booleans.length; i++) {
            booleans[i] = boolGen.next();
        }
        System.out.println(Arrays.toString(booleans));

        CountingGenerator.Byte byteGen = new CountingGenerator.Byte();
        byte[] bytes = new byte[6];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = byteGen.next();
        }
        System.out.println(Arrays.toString(bytes));

        char[] chars = new char[7];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = charGen.next();
        }
        System.out.println(Arrays.toString(chars));

        CountingGenerator.Short shortGen = new CountingGenerator.Short();
        short[] shorts = new short[8];
        for (int i = 0; i < shorts.length; i++) {
            shorts[i] = shortGen.next();
        }
        System.out.println(Arrays.toString(shorts));

        CountingGenerator.Integer intGen = new CountingGenerator.Integer();
        int[] ints = new int[9];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = intGen.next();
        }
        System.out.println(Arrays.toString(ints));

        CountingGenerator.Long longGen = new CountingGenerator.Long();
        long[] longs = new long[10];
        for (int i = 0; i < longs.length; i++) {
            longs[i] = longGen.next();
        }
        System.out.println(Arrays.toString(longs));

        CountingGenerator.Float floatGen = new CountingGenerator.Float();
        float[] floats = new float[11];
        for (int i = 0; i < floats.length; i++) {
            floats[i] = floatGen.next();
        }
        System.out.println(Arrays.toString(floats));
    }
}
