package com.github.frankkwok.tij4.generics;

import java.util.HashMap;
import java.util.Map;

/**
 * Page 494
 * Exercise 21: Modify ClassTypeCapture.java by adding a Map<String,Class<?>>, a method addType(String typename,
 * Class<?> kind), and a method createNew(String typename). createNew( ) will either produce a new instance of the class
 * associated with its argument string, or produce an error message.
 * <p>
 * Page 496
 * Exercise 24: Modify Exercise 21 so that factory objects are held in the Map instead of Class<?>.
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class ClassTypeCapture {
    private Map<String, FactoryI<?, Void>> classMap = new HashMap<>();

    public static void main(String[] args) {
        ClassTypeCapture ctc = new ClassTypeCapture();
        ctc.addType("Integer", new IntegerFactory());
        ctc.addType("Widget", new Widget.Factory());

        System.out.println(ctc.createNew("Integer"));
        System.out.println(ctc.createNew("Widget"));
        System.out.println(ctc.createNew("String"));
    }

    private void addType(String typename, FactoryI<?, Void> kind) {
        classMap.put(typename, kind);
    }

    private Object createNew(String typename) {
        return classMap.get(typename).create(null);
    }
}
