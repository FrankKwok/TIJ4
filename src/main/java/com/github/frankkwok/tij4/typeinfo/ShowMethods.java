package com.github.frankkwok.tij4.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

/**
 * Page 442
 * Exercise 17: Modify the regular expression in ShowMethods.java to additionally strip off the keywords native and
 * final (hint: use the OR operator’|’)-
 * Exercise 18: Make ShowMethods a non-public class and verify that the synthesized default constructor no longer shows
 * up in the output.
 *
 * @author Frank Kwok on 2017/5/11.
 */
class ShowMethods {
    private static String usage =
            "usage:\n" +
                    "ShowMethods qualified.class.name\n" +
                    "To show all methods in class or:\n" +
                    "ShowMethods qualified.class.name word\n" +
                    "To search for methods involving 'word'";
    private static Pattern pattern = Pattern.compile("(\\w+\\.)|\\s*final|\\s*native");

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println(usage);
            System.exit(0);
        }
        int lines = 0;
        try {
            Class<?> clazz = Class.forName(args[0]);
            Method[] methods = clazz.getMethods();
            Constructor[] constructors = clazz.getConstructors();
            if (args.length == 1) {
                for (Method m : methods) {
                    System.out.println(pattern.matcher(m.toString()).replaceAll(""));
                }
                for (Constructor c : constructors) {
                    System.out.println(pattern.matcher(c.toString()).replaceAll(""));
                }
                lines = methods.length + constructors.length;
            } else {
                for (Method m : methods) {
                    if (m.toString().contains(args[1])) {
                        System.out.println(pattern.matcher(m.toString()).replaceAll(""));
                        lines++;
                    }
                }
                for (Constructor c : constructors) {
                    if (c.toString().contains(args[1])) {
                        System.out.println(pattern.matcher(c.toString()).replaceAll(""));
                        lines++;
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + e);
        }
    }
}
