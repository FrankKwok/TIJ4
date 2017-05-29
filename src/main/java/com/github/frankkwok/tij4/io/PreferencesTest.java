package com.github.frankkwok.tij4.io;

import java.util.prefs.Preferences;

/**
 * Page 744
 * Exercise 33: Write a program that displays the current value of a directory called "base directory" and prompts you
 * for a new value. Use the Preferences API to store the value.
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class PreferencesTest {
    private static final String KEY_BASE_DIRECTORY = "base directory";

    public static void main(String[] args) {
        Preferences pref = Preferences.userNodeForPackage(PreferencesTest.class);
        System.out.println(pref.get(KEY_BASE_DIRECTORY, "something wrong"));
        pref.put(KEY_BASE_DIRECTORY, "C:\\Users\\Frank");
        System.out.println(pref.get(KEY_BASE_DIRECTORY, "something wrong"));
    }
}
