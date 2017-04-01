package com.github.frankkwok.tij4.object;

/**
 * Page 61
 * <p>
 * Exercise 10: Write a program that prints three arguments taken from the command line. To do this, you’ll need to
 * index into the command-line array of Strings.
 *
 * @author Frank Kwok on 2017/4/1.
 */
public class CommandLineArgsTest {
    public static void main(String[] args) {
        if (args.length >= 3) {
            System.out.println(args[0]);
            System.out.println(args[1]);
            System.out.println(args[2]);
        }
    }
}
