package com.github.frankkwok.tij4.holding;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * Page 317
 * Exercise 16: Create a Set of the vowels. Working from UniqueWords.Java, count and display the number of vowels in
 * each input word, and also display the total number of vowels in the input file.
 * <p>
 * Page 320
 * Exercise 20: Modify Exercise 16 so that you keep a count of the occurrence of each vowel.
 * Exercise 21: Using a Map<String,Integer>, follow the form of UniqueWords.java to create a program that counts the
 * occurrence of words in a file. Sort the results using Collections.sort( ) with a second argument of
 * String.CASE_INSENSITIVE_ORDER (to produce an alphabetic sort), and display the result.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class TextFile extends ArrayList<String> {
    public static String read(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(
                    new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public static void write(String fileName, String text) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                out.print(text);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TextFile(String fileName, String splitter) {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) remove(0);
    }

    public TextFile(String fileName) {
        this(fileName, "\n");
    }

    public void write(String fileName) {
        try {
            PrintWriter out = new PrintWriter(
                    new File(fileName).getAbsoluteFile());
            try {
                for (String item : this)
                    out.println(item);
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String file = read("TextFile.java");
        write("test.txt", file);
        TextFile text = new TextFile("test.txt");
        text.write("test2.txt");
        TreeSet<String> words = new TreeSet<>(
                new TextFile("TextFile.java", "\\W+"));
        System.out.println(words.headSet("a"));
    }
}
