package com.github.frankkwok.tij4.strings;

import com.github.frankkwok.tij4.util.TextFile;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Page 408
 * Exercise 15: Modify JGrep.java to accept flags as arguments (e.g., Pattern.CASE_INSENSITIVE, Pattern.MULTILINE).
 * Exercise 16: Modify JGrep.java to accept a directory name or a file name as argument (if a directory is provided,
 * search should include all files in the directory). Hint: You can generate a list of file names with:
 * File[] files = new File(".").listFiles();
 * Exercise 17: Write a program that reads a Java source-code file (you provide the file name on the command line) and
 * displays all the comments.
 * Exercise 18: Write a program that reads a Java source-code file (you provide the file name on the command line) and
 * displays all the string literals in the code.
 * Exercise 19: Building on the previous two exercises, write a program that examines Java source code and produces all
 * the class names used in a particular program.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class JGrep {
    static int index;

    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.out.println("Usage: java JGrep file regex");
            System.exit(0);
        }
        Pattern p = Pattern.compile(args[1], Integer.parseInt(args[2]));
        // Iterate through the lines of the input file:
        Matcher m = p.matcher("");

        acceptDir(args[0], m);
    }

    static void acceptDir(String filename, Matcher matcher) {
        File file = new File(filename).getAbsoluteFile();
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    acceptDir(f.getPath(), matcher);
                }
            }
        } else {
            for (String line : new TextFile(filename)) {
                matcher.reset(line);
                while (matcher.find()) {
                    System.out.println(index++ + ":" + matcher.group() + ":" + matcher.start());
                }
            }
        }
    }
}
