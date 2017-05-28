package com.github.frankkwok.tij4.io;

import com.github.frankkwok.tij4.util.OSExecute;

/**
 * Page 701
 * Exercise 22: Modify OSExecute.java so that, instead of printing the standard output stream, it returns the results of
 * executing the program as a List of Strings. Demonstrate the use of this new version of the utility.
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class OSExecuteTest {
    public static void main(String[] args) {
        System.out.println(OSExecute.command("dir C:\\Users\\Frank"));
    }
}
