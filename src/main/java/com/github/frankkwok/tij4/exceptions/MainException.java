package com.github.frankkwok.tij4.exceptions;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Page 372
 * Exercise 26: Change the file name string in MainException.java to name a file that doesn’t exist. Run the program
 * and note the result.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class MainException {
    public static void main(String[] args) throws IOException {
        FileInputStream file =
                new FileInputStream("MainException.java");
        file.close();
    }
}
