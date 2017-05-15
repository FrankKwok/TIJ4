package com.github.frankkwok.tij4.typoinfo;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Page 421
 * Exercise 8: Write a method that takes an object and recursively prints all the classes in that object’s hierarchy.
 * Exercise 9: Modify the previous exercise so that it uses Class.getDeclaredFields( ) to also display information about
 * the fields in a class.
 * Exercise 10: Write a program to determine whether an array of char is a primitive type or a true Object.
 *
 * @author Frank Kwok on 2017/5/10.
 */
public class HierarchyInfoTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> string = Class.forName("java.lang.String");
        printHierarchy(string);
        printField(string);

        printHierarchy(char[].class);
    }

    static void printHierarchy(Class<?> clazz) {
        do {
            System.out.println(clazz);
            clazz = clazz.getSuperclass();
        } while (clazz != null);
    }

    static void printField(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            if (!Modifier.isStatic(f.getModifiers())) {
                System.out.println("Field: " + f.getName());
                printHierarchy(f.getType());
            }
        }
    }
}
