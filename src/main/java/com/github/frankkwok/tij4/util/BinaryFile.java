package com.github.frankkwok.tij4.util;

import java.io.*;

/**
 * @author Frank Kwok on 2017/5/28.
 */
public class BinaryFile {
    public static byte[] read(File file) throws IOException {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            return bytes;
        }
    }

    public static byte[] read(String filename) throws IOException {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename))) {
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            return bytes;
        }
    }
}
