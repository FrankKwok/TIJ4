package com.github.frankkwok.tij4.strings;

/**
 * Page 398
 * Exercise 10: For the phrase "Java now has regular expressions" evaluate whether the following expressions will find
 * a match:
 * ^Java
 * \Breg.*
 * n.w\s+h(a|i)s
 * s?
 * s*
 * s+
 * s{4}
 * S{1}.
 * s{0,3}
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class MatchTest {
    private static String string = "Java now has regular expressions";

    public static void main(String[] args) {
        printMatch("^Java");
        printMatch("\\Breg.*");
        printMatch("n.w\\s+h(a|i)s");
        printMatch("s?");
        printMatch("s*");
        printMatch("s+");
        printMatch("s{4}");
        printMatch("S{1}.");
        printMatch("s{0,3}");
    }

    static void printMatch(String regex) {
        System.out.printf("%s: %b%n", regex, string.matches(regex));
    }
}
