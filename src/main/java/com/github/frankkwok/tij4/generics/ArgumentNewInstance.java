package com.github.frankkwok.tij4.generics;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Page 496
 * Exercise 22: Use a type tag along with reflection to create a method that uses the argument version of newInstance()
 * to create an object of a class with a constructor that has arguments.
 *
 * @author Frank Kwok on 2017/5/17.
 */
public class ArgumentNewInstance {
    public static void main(String[] args) {
        A a = (A) createNew(A.class, "hello, world");
        System.out.println(a);
    }

    private static Object createNew(Class<?> clazz, Object... args) {
        Class<?>[] classes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            classes[i] = args[i].getClass();
        }
        try {
            Constructor<?> constructor = clazz.getDeclaredConstructor(classes);
            return constructor.newInstance(args);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}

class A {
    private String string;

    public A(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return string;
    }
}
