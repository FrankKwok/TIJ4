package com.github.frankkwok.tij4.object;

/**
 * Page 61
 * <p>
 * Exercise 6: Write a program that includes and calls the storage( ) method defined as a code fragment in this chapter.
 *
 * @author Frank Kwok on 2017/4/1.
 */
public class Storage {
    public static void main(String[] args) {
        Storage s = new Storage();
        System.out.println(s.storage("hello, world"));
    }

    private int storage(String s) {
        return s.length() * 2;
    }
}
