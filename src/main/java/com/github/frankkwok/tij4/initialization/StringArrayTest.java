package com.github.frankkwok.tij4.initialization;

/**
 * Page 158
 * Exercise 16: Create an array of String objects and assign a String to each element. Print the array by using a for
 * loop.
 *
 * @author Frank Kwok on 2017/4/8.
 */
public class StringArrayTest {
    public static void main(String[] args) {
        String[] strings = new String[3];
        strings[0] = "frank";
        strings[1] = "kwok";
        strings[2] = "ghl";

        for (String s : strings) {
            System.out.println(s);
        }
    }
}
