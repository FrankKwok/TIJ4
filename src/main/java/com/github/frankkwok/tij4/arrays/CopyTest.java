package com.github.frankkwok.tij4.arrays;

import java.util.Arrays;

/**
 * Page 578
 * Exercise 18: Create and fill an array of BerylliumSphere. Copy this array to a new array and show that it’s a shallow
 * copy.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class CopyTest {
    public static void main(String[] args) {
        BerylliumSphere[] berylliumSpheres = new BerylliumSphere[10];
        for (int i = 0; i < 10; i++) {
            berylliumSpheres[i] = new BerylliumSphere();
        }
        System.out.println(Arrays.toString(berylliumSpheres));

        BerylliumSphere[] copy = new BerylliumSphere[berylliumSpheres.length];
        System.arraycopy(berylliumSpheres, 0, copy, 0, berylliumSpheres.length);
        System.out.println(Arrays.toString(copy));
    }
}
