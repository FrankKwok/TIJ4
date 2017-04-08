package com.github.frankkwok.tij4.initialization;

/**
 * Page 158
 * Exercise 17: Create a class with a constructor that takes a String argument. During construction, print the argument.
 * Create an array of object references to this class, but don’t actually create objects to assign into the array. When
 * you run the program, notice whether the initialization messages from the constructor calls are printed.
 * Exercise 18: Complete the previous exercise by creating objects to attach to the array of references.
 *
 * @author Frank Kwok on 2017/4/8.
 */
public class StringArgsTest {
    private StringArgsTest(String[] strings) {
        for (String s : strings) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        new StringArgsTest(new String[3]);

        new StringArgsTest(new String[]{"ghl", "frank", "kwok"});
    }
}
