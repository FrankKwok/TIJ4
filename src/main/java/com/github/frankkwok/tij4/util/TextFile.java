package com.github.frankkwok.tij4.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Frank Kwok on 2017/5/8.
 */
public class TextFile extends ArrayList<String> {
    public TextFile(String fileName, String splitter) throws IOException {
        super(Arrays.asList(read(fileName).split(splitter)));
        if (get(0).equals("")) {
            remove(0);
        }
    }

    public TextFile(String fileName) throws IOException {
        this(fileName, "\n");
    }

    public static String read(String fileName) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()))) {
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public static void write(String fileName, String text) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile())) {
            out.print(text);
        }
    }


    public void write(String fileName) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile())) {
            for (String item : this) {
                out.println(item);
            }
        }
    }
}
