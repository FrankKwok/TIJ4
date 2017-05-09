package com.github.frankkwok.tij4.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Page 399
 * Exercise 11: Apply the regular expression
 * (?i)((^[aeiou])|(\s+[aeiou]))\w+?[aeiou]\b
 * to
 * "Arline ate eight apples and one orange while Anita hadn’t any"
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class RegularExpressionTest {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b");

        Matcher matcher = pattern.matcher("Arline ate eight apples and one orange while Anita hadn’t any");
        while (matcher.find()) {
            System.out.printf("Match \" %s\" at position %d-%d%n", matcher.group(), matcher.start(), matcher.end() - 1);
        }
    }
}
