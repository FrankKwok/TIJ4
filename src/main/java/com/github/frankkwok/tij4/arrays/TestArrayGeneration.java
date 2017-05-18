package com.github.frankkwok.tij4.arrays;

import com.github.frankkwok.tij4.util.ConvertTo;
import com.github.frankkwok.tij4.util.Generated;
import com.github.frankkwok.tij4.util.SkipGenerator;

import java.util.Arrays;

/**
 * Page 577
 * Exercise 16: Starting with CountingGenerator.java, create a SkipGenerator class that produces new values by
 * incrementing according to a constructor argument. Modify TestArrayGeneration.java to show that your new class works
 * correctly.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class TestArrayGeneration {
    public static void main(String[] args) {
        int size = 6;
        int skip = 3;
        boolean[] a1 = ConvertTo.primitive(Generated.array(Boolean.class, new SkipGeneratorUtil.Boolean(skip), size));
        System.out.println("a1 = " + Arrays.toString(a1));

        byte[] a2 = ConvertTo.primitive(Generated.array(Byte.class, new SkipGeneratorUtil.Byte(skip), size));
        System.out.println("a2 = " + Arrays.toString(a2));

        char[] a3 = ConvertTo.primitive(Generated.array(Character.class, new SkipGeneratorUtil.Character(skip), size));
        System.out.println("a3 = " + Arrays.toString(a3));

        short[] a4 = ConvertTo.primitive(Generated.array(Short.class, new SkipGeneratorUtil.Short(skip), size));
        System.out.println("a4 = " + Arrays.toString(a4));

        int[] a5 = ConvertTo.primitive(Generated.array(Integer.class, new SkipGeneratorUtil.Integer(skip), size));
        System.out.println("a5 = " + Arrays.toString(a5));

        long[] a6 = ConvertTo.primitive(Generated.array(Long.class, new SkipGeneratorUtil.Long(skip), size));
        System.out.println("a6 = " + Arrays.toString(a6));

        float[] a7 = ConvertTo.primitive(Generated.array(Float.class, new SkipGeneratorUtil.Float(skip), size));
        System.out.println("a7 = " + Arrays.toString(a7));

        double[] a8 = ConvertTo.primitive(Generated.array(Double.class, new SkipGeneratorUtil.Double(skip), size));
        System.out.println("a8 = " + Arrays.toString(a8));
    }
}

class SkipGeneratorUtil {
    public static class Boolean implements SkipGenerator<java.lang.Boolean> {
        private boolean value = false;
        private int n;

        Boolean(int n) {
            this.n = n;
        }

        public java.lang.Boolean next() {
            return !value;
        }

        public java.lang.Boolean next(int n) {
            value = n % 2 == 0;
            return value;
        }
    }

    public static class Byte implements SkipGenerator<java.lang.Byte> {
        private byte value = 0;
        private int n;

        Byte(int n) {
            this.n = n;
        }

        public java.lang.Byte next() {
            return value++;
        }

        public java.lang.Byte next(int n) {
            return value += n;
        }
    }

    static char[] chars = ("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();

    public static class Character implements SkipGenerator<java.lang.Character> {
        int index = -1;
        private int n;

        Character() {
            int index = -1;
        }

        Character(int n) {
            this.n = n;
        }

        public java.lang.Character next() {
            index = (index + 1) % chars.length;
            return chars[index];
        }

        public java.lang.Character next(int n) {
            index = (index + 1 + n) % chars.length;
            return chars[index];
        }
    }

    public static class String implements SkipGenerator<java.lang.String> {
        private int length = 7;
        SkipGenerator<java.lang.Character> cg = new Character();

        public String() {
        }

        public String(int length) {
            this.length = length;
        }

        public java.lang.String next() {
            char[] buf = new char[length];
            for (int i = 0; i < length; i++)
                buf[i] = cg.next();
            return new java.lang.String(buf);
        }

        public java.lang.String next(int n) {
            char[] buf = new char[length];
            for (int i = 0; i < length; i++)
                buf[i] = cg.next(n);
            return new java.lang.String(buf);
        }
    }

    public static class Short implements SkipGenerator<java.lang.Short> {
        private short value = 0;
        private int n;

        Short(int n) {
            this.n = n;
        }

        public java.lang.Short next() {
            return value++;
        }

        public java.lang.Short next(int n) {
            return value += n;
        }
    }

    public static class Integer implements SkipGenerator<java.lang.Integer> {
        private int value = 0;
        private int n;

        Integer(int n) {
            this.n = n;
        }

        public java.lang.Integer next() {
            return value++;
        }

        public java.lang.Integer next(int n) {
            return value += n;
        }
    }

    public static class Long implements SkipGenerator<java.lang.Long> {
        private long value = 0;
        private int n;

        Long(int n) {
            this.n = n;
        }

        public java.lang.Long next() {
            return value++;
        }

        public java.lang.Long next(int n) {
            return value += n;
        }
    }

    public static class Float implements SkipGenerator<java.lang.Float> {
        private float value = 0;
        private int n;

        Float(int n) {
            this.n = n;
        }

        public java.lang.Float next() {
            float result = value;
            value += 1.0;
            return result;
        }

        public java.lang.Float next(int n) {
            float result = value;
            value += (1.0 * n);
            return result;
        }
    }

    public static class Double implements SkipGenerator<java.lang.Double> {
        private double value = 0.0;
        private int n;

        Double(int n) {
            this.n = n;
        }

        public java.lang.Double next() {
            double result = value;
            value += 1.0;
            return result;
        }

        public java.lang.Double next(int n) {
            double result = value;
            value += (1.0 * n);
            return result;
        }
    }
}
