package com.github.frankkwok.tij4.access;

//import com.github.frankkwok.tij4.access.debug.Debug;

import com.github.frankkwok.tij4.access.debugoff.Debug;

/**
 * Page 174
 * Exercise 3: Create two packages: debug and debugoff, containing an identical class with a debug( ) method. The first
 * version displays its String argument to the console, the second does nothing. Use a static import line to import the
 * class into a test program, and demonstrate the conditional compilation effect.
 *
 * @author Frank Kwok on 2017/4/9.
 */
public class DebugTest {
    public static void main(String[] args) {
        Debug debug = new Debug();
        debug.debug();
    }
}
