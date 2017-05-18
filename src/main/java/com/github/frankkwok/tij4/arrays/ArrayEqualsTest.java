package com.github.frankkwok.tij4.arrays;

import java.util.Arrays;

/**
 * Page 579
 * Exercise 19: Create a class with an int field that’s initialized from a constructor argument. Create two arrays of
 * these objects, using identical initialization values for each array, and show that Arrays.equals( ) says that they
 * are unequal. Add an equals( ) method to your class to fix the problem.
 * Exercise 20: Demonstrate deepEquals( ) for multidimensional arrays.
 * <p>
 * Page 585
 * Exercise 24: Show that the class from Exercise 19 can be searched.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class ArrayEqualsTest {
    public static void main(String[] args) {
        EqualsTest[] equalsTests1 = new EqualsTest[5];
        for (int i = 0; i < equalsTests1.length; i++) {
            equalsTests1[i] = new EqualsTest(i);
        }
        EqualsTest[] equalsTests2 = new EqualsTest[5];
        for (int i = 0; i < equalsTests2.length; i++) {
            equalsTests2[i] = new EqualsTest(i);
        }
        System.out.println(Arrays.equals(equalsTests1, equalsTests2));

        int[][] ints1 = {{1, 2, 3}, {2, 3, 4}};
        int[][] ints2 = {{1, 2, 3}, {2, 3, 4}};
        System.out.println(Arrays.deepEquals(ints1, ints2));

        Arrays.sort(equalsTests1);
        System.out.println(Arrays.binarySearch(equalsTests1, new EqualsTest(2)));
    }
}

class EqualsTest implements Comparable<EqualsTest> {
    private int i;

    EqualsTest(int i) {
        this.i = i;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        EqualsTest other = (EqualsTest) otherObject;
        return i == other.i;
    }

    @Override
    public int compareTo(EqualsTest other) {
        return Integer.compare(i, other.i);
    }
}
