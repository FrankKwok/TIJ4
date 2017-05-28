package com.github.frankkwok.tij4.strings;

import com.github.frankkwok.tij4.util.TextFile;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Page 408
 * Exercise 15: Modify JGrep.java to accept flags as arguments (e.g., Pattern.CASE_INSENSITIVE, Pattern.MULTILINE).
 * Exercise 16: Modify JGrep.java to accept a directory name or a file name as argument (if a directory is provided,
 * search should include all files in the directory). Hint: You can generate a list of file names with:
 * File[] files = new File(".").listFiles();
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class JGrep {
    private static int index;

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

    private static void acceptDir(String filename, Matcher matcher) throws IOException {
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
