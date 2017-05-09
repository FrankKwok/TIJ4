package com.github.frankkwok.tij4.strings;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Page 405
 * Exercise 14: Rewrite SplitDemo using String.split( ).
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class SplitDemo {
    public static void main(String[] args) {
        String input =
                "This!!unusual use!!of exclamation!!points";
        System.out.println("String.split(): ");
        System.out.println(Arrays.toString(input.split("!!")));
        System.out.println(Arrays.toString(input.split("!!", 3)));
        System.out.println("Pattern.split(): ");
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input)));
        System.out.println(Arrays.toString(Pattern.compile("!!").split(input, 3)));
    }
}
