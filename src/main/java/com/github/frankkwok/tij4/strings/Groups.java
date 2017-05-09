package com.github.frankkwok.tij4.strings;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Page 401
 * Exercise 12: Modify Groups.java to count all of the unique words that do not start with a capital letter.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class Groups {
    static final String POEM =
            "Twas brillig, and the slithy toves\n" +
                    "Did gyre and gimble in the wabe.\n" +
                    "All mimsy were the borogoves,\n" +
                    "And the mome raths outgrabe.\n\n" +
                    "Beware the Jabberwock, my son,\n" +
                    "The jaws that bite, the claws that catch.\n" +
                    "Beware the Jubjub bird, and shun\n" +
                    "The frumious Bandersnatch.";

    public static void main(String[] args) {
        Matcher matcher = Pattern.compile("\\b\\p{javaLowerCase}\\w*").matcher(POEM);
        Set<String> set = new HashSet<>();
        while (matcher.find()) {
            set.add(matcher.group());
        }
        System.out.println(set);
    }
}
