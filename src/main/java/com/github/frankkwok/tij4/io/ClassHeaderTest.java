package com.github.frankkwok.tij4.io;

import com.github.frankkwok.tij4.util.BinaryFile;
import com.github.frankkwok.tij4.util.Directory;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Page 697
 * Exercise 20: Using Directory.walk( ) and BinaryFile, verify that all .class files in a directory tree begin with the
 * hex characters ‘CAFEBABE’.
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class ClassHeaderTest {
    private static final String TEST_DIR = "C:\\Users\\Frank\\Codes\\Source\\TIJ4-code";

    public static void main(String[] args) throws IOException {
        Directory.TreeInfo treeInfo = Directory.walk(TEST_DIR, ".*\\.class");
        for (File file : treeInfo.files) {
            byte[] bytes = BinaryFile.read(file);
            for (int i = 0; i < 4; i++) {
                System.out.print(Integer.toHexString(bytes[i]) + " ");
            }
            System.out.println();
        }
    }
}
