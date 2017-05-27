package com.github.frankkwok.tij4.io;

import com.github.frankkwok.tij4.util.ProcessFiles;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

/**
 * Page 676
 * Exercise 5: Modify ProcessFiles.java so that it matches a regular expression rather than a fixed extension.
 * <p>
 * Page 678
 * Exercise 6: Use ProcessFiles to find all the Java source-code files in a particular directory subtree that have been
 * modified after a particular date.
 *
 * @author Frank Kwok on 2017/5/27.
 */
public class ProcessFilesTest {
    public static void main(String[] args) throws IOException {
        long oneMonthBefore = LocalDateTime.of(2017, 4, 27, 17, 30).getLong(ChronoField.MILLI_OF_SECOND);
        ProcessFiles processFiles = new ProcessFiles(file -> {
            if (file.lastModified() > oneMonthBefore) {
                System.out.println(file);
            }
        }, "java");
        processFiles.processDirectoryTree(new File("C:\\Users\\Frank\\Codes\\IdeaProjects\\CoreJava"));
    }
}
