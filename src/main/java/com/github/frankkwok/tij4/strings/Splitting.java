package com.github.frankkwok.tij4.strings;

import java.util.Arrays;

/**
 * Page 394
 * Exercise 8: Split the string Splitting.knights on the words "the" or “you."
 * Exercise 9: Using the documentation for java.util.regex.Pattern as a resource, replace all the vowels in
 * Splitting.knights with underscores.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class Splitting {
    public static String knights =
            "Then, when you have found the shrubbery, you must " +
                    "cut down the mightiest tree in the forest... " +
                    "with... a herring!";

    public static void main(String[] args) {
        split(" ");
        split("\\W+");
        split("n\\W+");
        split("the|you");

        replaceAll("a|A|e|E|i|I|o|O|u|U", "_");
    }

    public static void split(String regex) {
        System.out.println(
                Arrays.toString(knights.split(regex)));
    }

    public static void replaceAll(String regex, String replacement) {
        System.out.println(knights.replaceAll(regex, replacement));
    }
}
