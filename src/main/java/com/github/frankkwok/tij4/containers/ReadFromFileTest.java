package com.github.frankkwok.tij4.containers;

import com.github.frankkwok.tij4.util.TextFile;

import java.io.IOException;
import java.util.Collection;

/**
 * Page 601
 * Exercise 4: Create a Collection initializer that opens a file and breaks it into words using TextFile, and then uses
 * the words as the source of data for the resulting Collection. Demonstrate that it works.
 *
 * @author Frank Kwok on 2017/5/19.
 */
public class ReadFromFileTest {
    public static void main(String[] args) throws IOException {
        Collection<String> collection = new TextFile(".gitignore");
        System.out.println(collection);
    }
}
