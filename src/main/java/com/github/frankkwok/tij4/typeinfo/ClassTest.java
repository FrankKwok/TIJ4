package com.github.frankkwok.tij4.typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Page 442
 * Exercise 20: Look up the interface for java.lang.Class in the JDK documentation from http://java.sun.com. Write a
 * program that takes the name of a class as a command-line argument, then uses the Class methods to dump all the
 * information available for that class. Test your program with a standard library class and a class you create.
 *
 * @author Frank Kwok on 2017/5/11.
 */
public class ClassTest {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Need a class name.");
            System.exit(0);
        }
        try {
            Class<?> clazz = Class.forName(args[0]);

            String modifier = Modifier.toString(clazz.getModifiers());
            if (modifier.length() > 0) {
                System.out.print(modifier + " ");
            }
            System.out.print(clazz.getName() + " ");
            Class<?> superclass = clazz.getSuperclass();
            if (superclass != null && superclass != Object.class) {
                System.out.print(" extends " + superclass.getName() + " ");
            }
            Class<?>[] interfaces = clazz.getInterfaces();
            if (interfaces.length > 0) {
                System.out.print("implements ");
                for (int i = 0; i < interfaces.length; i++) {
                    if (i > 0) {
                        System.out.print(", ");
                    }
                    System.out.print(interfaces[i].getName());
                }
                System.out.print(" ");
            }
            System.out.println("{");


            for (Field field : clazz.getDeclaredFields()) {
                System.out.println("    " + field);
            }
            System.out.println();

            for (Constructor constructor : clazz.getDeclaredConstructors()) {
                System.out.println("    " + constructor);
            }
            System.out.println();

            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println("    " + method);
            }
            System.out.println();

            System.out.println("}");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e);
        }
    }
}
