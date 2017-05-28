package com.github.frankkwok.tij4.io;

import com.github.frankkwok.tij4.util.TextFile;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Page 672
 * Exercise 1: Modify DirList.java (or one of its variants) so that the FilenameFilter opens and reads each file (using
 * the net.mindview.util.TextFile utility) and accepts the file based on whether any of the trailing arguments on the
 * command line exist in that file.
 * Exercise 3: Modify DirList.java (or one of its variants) so that it sums up the file sizes of the selected files.
 *
 * @author Frank Kwok on 2017/5/26.
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0)
            list = path.list();
        else {
            SizeFilter filter = new SizeFilter(args[0]);
            list = path.list(filter);
            System.out.println(filter.getSize());
        }
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }

    static class SizeFilter implements FilenameFilter {
        private Pattern pattern;
        private int size;

        SizeFilter(String regex) {
            pattern = Pattern.compile(regex);
            size = 0;
        }

        @Override
        public boolean accept(File dir, String name) {
            File file = new File(name);
            if (file.isFile() && file.canRead()) {
                size += file.length();
                try {
                    System.out.println(new TextFile(name));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return pattern.matcher(name).matches();
        }

        public int getSize() {
            return size;
        }
    }
}
