package com.github.frankkwok.tij4.io;

import java.io.*;

/**
 * Page 691
 * Exercise 13: Modify BasicFileOutput.java so that it uses LineNumberReader to keep track of the line count. Note that
 * it’s much easier to just keep track programmatically.
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class BasicFileOutput {
    private static final String OUT_NAME = "BasicFileOutput.out";

    public static void main(String[] args) {
        try (LineNumberReader in = new LineNumberReader(new FileReader(ReadFileByLine.GIT_IGNORE));
             PrintWriter out = new PrintWriter(OUT_NAME)) {
            String line;
            while ((line = in.readLine()) != null) {
                out.print(in.getLineNumber());
                out.print(": ");
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
