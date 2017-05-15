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
 * Exercise 17: Write a program that reads a Java source-code file (you provide the file name on the command line) and
 * displays all the comments.
 *
 * @author Frank Kwok on 2017/5/15.
 */
public class CommentRegx {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Need a Java source-code file path");
            System.exit(0);
        }
        displayComments(args[0]);
    }

    static void displayComments(String filename) throws IOException {
        List<String> stringList = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8);
        StringBuilder sb = new StringBuilder();
        for (String s : stringList) {
            sb.append(s);
            sb.append("\n");
        }
        Pattern mutLine = Pattern.compile("/\\*.+\\*/", Pattern.DOTALL);
        Matcher mutMatcher = mutLine.matcher(sb);
        while (mutMatcher.find()) {
            System.out.println(sb.substring(mutMatcher.start(), mutMatcher.end() - 1));
        }

        Pattern sinLine = Pattern.compile("//.+\\n");
        Matcher sinMather = sinLine.matcher(sb);
        while (sinMather.find()) {
            System.out.println(sb.substring(sinMather.start(), sinMather.end() - 1));
        }
    }
}
