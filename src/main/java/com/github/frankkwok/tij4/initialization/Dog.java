package com.github.frankkwok.tij4.initialization;

/**
 * Page 137
 * Exercise 5: Create a class called Dog with an overloaded bark( ) method. This method should be overloaded based on
 * various primitive data types, and print different types of barking, howling, etc., depending on which overloaded
 * version is called. Write a main( ) that calls all the different versions.
 * Exercise 6: Modify the previous exercise so that two of the overloaded methods have two arguments (of two different
 * types), but in reversed order relative to each other. Verify that this works.
 *
 * @author Frank Kwok on 2017/4/8.
 */
public class Dog {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.bark("hello", 2);
        dog.bark(3, "world");
    }

    private void bark(String string, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("barking " + string + " " + i);
        }
    }

    private void bark(int n, String string) {
        for (int i = 0; i < n; i++) {
            System.out.println("howling " + string + " " + i);
        }
    }
}
