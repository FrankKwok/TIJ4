package com.github.frankkwok.tij4.strings;

/**
 * Page 394
 * Exercise 7: Using the documentation for java.util.regex.Pattern as a resource, write and test a regular expression
 * that checks a sentence to see that it begins with a capital letter and ends with a period.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class PatternTest {
    public static void main(String[] args) {
        match("hello, world!");
        match("Hello, world!");
        match("Hello, world.");
    }

    static void match(String string) {
        System.out.printf("%s.match(%s): %b%n", string, "\\p{Upper}.*\\.+", string.matches("\\p{Upper}.*\\.+"));
    }
}
