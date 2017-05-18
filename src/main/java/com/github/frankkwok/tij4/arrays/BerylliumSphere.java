package com.github.frankkwok.tij4.arrays;

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
public class BerylliumSphere {
    private static long counter;
    private final long id = counter++;

    public String toString() {
        return "Sphere " + id;
    }
}
