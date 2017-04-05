package com.github.frankkwok.tij4.operators;

/**
 * Page 113
 * Exercise 14: Write a method that takes two String arguments and uses all the boolean comparisons to compare the two
 * Strings and print the results. For the == and !=, also perform the equals( ) test. In main( ), call your method with
 * some different String objects.
 *
 * @author Frank Kwok on 2017/4/5.
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        System.out.println("s1==s2: " + (s1 == s2));
        System.out.println("s1!=s2: " + (s1 != s2));
        System.out.println("s1.equals(s2): " + s1.equals(s2));
    }
}
