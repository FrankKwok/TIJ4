package com.github.frankkwok.tij4.arrays;

import java.util.Arrays;

/**
 * Page 560
 * Exercise 1: Create a method that takes an array of BerylliumSphere as an argument. Call the method, creating the
 * argument dynamically. Demonstrate that ordinary aggregate array initialization doesn’t work in this case. Discover
 * the only situations where ordinary aggregate array initialization works, and where dynamic aggregate initialization
 * is redundant.
 * <p>
 * Page 562
 * Exercise 2: Write a method that takes an int argument and returns an array of that size, filled with BerylliumSphere
 * objects.
 * <p>
 * Page 565
 * Exercise 6: Write a method that takes two int arguments, indicating the two sizes of a 2-D array. The method should
 * create and fill a 2-D array of BerylliumSphere according to the size arguments.
 * Exercise 7: Repeat the previous exercise for a 3-D array.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class BerylliumSphereTest {
    public static void main(String[] args) {
//        take({new BerylliumSphere(), new BerylliumSphere()});
        take(new BerylliumSphere[]{new BerylliumSphere(), new BerylliumSphere()});
    }

    private static void take(BerylliumSphere[] berylliumSpheres) {
        System.out.println(Arrays.toString(berylliumSpheres));
    }

    static BerylliumSphere[] fill(int n) {
        BerylliumSphere[] berylliumSpheres = new BerylliumSphere[n];
        for (int i = 0; i < n; i++) {
            berylliumSpheres[i] = new BerylliumSphere();
        }
        return berylliumSpheres;
    }

    static BerylliumSphere[][] createAndFill(int l1, int l2) {
        BerylliumSphere[][] berylliumSpheres = new BerylliumSphere[l1][l2];
        for (int i = 0; i < berylliumSpheres.length; i++) {
            for (int j = 0; j < berylliumSpheres[i].length; j++) {
                berylliumSpheres[i][j] = new BerylliumSphere();
            }
        }
        return berylliumSpheres;
    }

    static BerylliumSphere[][][] createAndFill(int l1, int l2, int l3) {
        BerylliumSphere[][][] berylliumSpheres = new BerylliumSphere[l1][l2][l3];
        for (int i = 0; i < berylliumSpheres.length; i++) {
            for (int j = 0; j < berylliumSpheres[i].length; j++) {
                for (int k = 0; k < berylliumSpheres[i][j].length; k++) {
                    berylliumSpheres[i][j][k] = new BerylliumSphere();
                }
            }
        }
        return berylliumSpheres;
    }
}
