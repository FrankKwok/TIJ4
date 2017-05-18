package com.github.frankkwok.tij4.arrays;

import com.github.frankkwok.tij4.util.CountingGenerator;

import java.util.Arrays;

/**
 * Page 576
 * Exercise 15: Modify ContainerComparison.java by creating a Generator for BerylliumSphere, and change main( ) to use
 * that Generator with Generated.array().
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class ContainerComparison {
    public static void main(String[] args) {
        CountingGenerator.BerylliumSphere gen = new CountingGenerator.BerylliumSphere();
        BerylliumSphere[] berylliumSpheres = new BerylliumSphere[5];
        for (int i = 0; i < berylliumSpheres.length; i++) {
            berylliumSpheres[i] = gen.next();
        }
        System.out.println(Arrays.toString(berylliumSpheres));
    }
}
