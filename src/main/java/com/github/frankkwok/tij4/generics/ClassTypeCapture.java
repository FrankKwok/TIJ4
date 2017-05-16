package com.github.frankkwok.tij4.generics;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Page 494
 * Exercise 21: Modify ClassTypeCapture.java by adding a Map<String,Class<?>>, a method addType(String typename,
 * Class<?> kind), and a method createNew(String typename). createNew( ) will either produce a new instance of the class
 * associated with its argument string, or produce an error message.
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class ClassTypeCapture {
    Map<String, Class<?>> classMap = new HashMap<>();

    public static void main(String[] args) {
        ClassTypeCapture ctc = new ClassTypeCapture();
        ctc.addType("Date", Date.class);
        ctc.addType("String", String.class);

        System.out.println(ctc.createNew("Date"));
        System.out.println(ctc.createNew("String"));
        System.out.println(ctc.createNew("Integer"));
    }

    public void addType(String typename, Class<?> kind) {
        classMap.put(typename, kind);
    }

    public Object createNew(String typename) {
        try {
            return classMap.get(typename).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
