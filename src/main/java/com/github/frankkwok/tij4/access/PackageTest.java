package com.github.frankkwok.tij4.access;

import com.github.frankkwok.tij4.access.packagetest.InPackage;

/**
 * Page 172
 * Exercise 1: Create a class in a package. Create an instance of your class outside of that package.
 *
 * @author Frank Kwok on 2017/4/9.
 */
public class PackageTest {
    public static void main(String[] args) {
        InPackage inPackage = new InPackage();
        inPackage.test();
    }
}
