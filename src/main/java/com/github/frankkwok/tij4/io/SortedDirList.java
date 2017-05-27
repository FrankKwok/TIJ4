package com.github.frankkwok.tij4.io;

import java.io.File;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Page 672
 * Exercise 2: Create a class called SortedDirList with a constructor that takes a File object and builds a sorted
 * directory list from the files at that File. Add to this class two overloaded list( ) methods: the first produces the
 * whole list, and the second produces the subset of the list that matches its argument (which is a regular expression).
 *
 * @author Frank Kwok on 2017/5/26.
 */
public class SortedDirList {
    private File directory;

    public SortedDirList(File directory) {
        this.directory = directory;
    }

    public void list() {
        String[] list = directory.list();
        if (list != null) {
            Arrays.sort(list);
            System.out.println(Arrays.toString(list));
        }
    }

    public void list(String regex) {
        Pattern pattern = Pattern.compile(regex);
        String[] list = directory.list((dir, name) -> pattern.matcher(name).matches());
        if (list != null) {
            Arrays.sort(list);
            System.out.println(Arrays.toString(list));
        }
    }
}
