package com.github.frankkwok.tij4.strings;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Page 408
 * Exercise 18: Write a program that reads a Java source-code file (you provide the file name on the command line) and
 * displays all the string literals in the code.
 *
 * @author Frank Kwok on 2017/5/15.
 */
public class literalRegx {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Need a Java source-code file path");
            System.exit(0);
        }
        displayLiterals(args[0]);
    }

    static void displayLiterals(String filename) throws IOException {
        List<String> stringList = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String s : stringList) {
            sb.append(s);
            sb.append("\n");
        }
        Pattern pattern = Pattern.compile("\".*\"");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            System.out.println(sb.substring(matcher.start(), matcher.end()));
        }
    }
}
