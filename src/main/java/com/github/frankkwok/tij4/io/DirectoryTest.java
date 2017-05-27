package com.github.frankkwok.tij4.io;

import com.github.frankkwok.tij4.util.Directory;

import java.io.File;

/**
 * Page 676
 * Exercise 4: Use Directory.walk() to sum the sizes of all files in a directory tree whose names match a particular
 * regular expression.
 *
 * @author Frank Kwok on 2017/5/27.
 */
public class DirectoryTest {
    public static void main(String[] args) {
        int size = 0;
        Directory.TreeInfo treeInfo = Directory.walk("C:\\Users\\Frank\\Codes\\IdeaProjects\\CoreJava");
        for (File file : treeInfo.files) {
            size += file.length();
        }
        System.out.println(size);
    }
}
