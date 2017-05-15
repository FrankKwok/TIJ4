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
 * Exercise 19: Building on the previous two exercises, write a program that examines Java source code and produces all
 * the class names used in a particular program.
 *
 * @author Frank Kwok on 2017/5/15.
 */
public class ClassNameRegx {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Need a Java source-code file path");
            System.exit(0);
        }
        displayClassNames(args[0]);
    }

    private static void displayClassNames(String filename) throws IOException {
        List<String> stringList = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String s : stringList) {
            sb.append(s);
            sb.append("\n");
        }
        Pattern pattern = Pattern.compile("class\\s+([a-zA-Z]\\w*)\\s+", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            System.out.println(sb.substring(matcher.start(1), matcher.end(1)));
        }
    }
}
