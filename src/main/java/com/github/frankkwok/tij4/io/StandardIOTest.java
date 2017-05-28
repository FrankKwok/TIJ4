package com.github.frankkwok.tij4.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Page 698
 * Exercise 21: Write a program that takes standard input and capitalizes all characters, then puts the results on
 * standard output. Redirect the contents of a file into this program (the process of redirection will vary depending on
 * your operating system).
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class StandardIOTest {
    private static final String FILE_NAME = "StandardIOTest.out";

    public static void main(String[] args) throws IOException {
        try (Scanner in = new Scanner(System.in);
             PrintStream out = new PrintStream(new FileOutputStream(FILE_NAME))) {
            System.setOut(out);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                System.out.println(line.toUpperCase());
            }
        }
    }
}
