package com.github.frankkwok.tij4.typoinfo;

import com.github.frankkwok.tij4.typoinfo.access.WithFields;

import java.lang.reflect.Field;

/**
 * Page 457
 * Exercise 25: Create a class containing private, protected and package-access methods. Write code to access these
 * methods from outside of the class’s package.
 *
 * @author Frank Kwok on 2017/5/15.
 */
public class AccessFieldsOutside {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        WithFields wf = new WithFields();
        System.out.println(wf);
        set(wf, "i1", 50);
        System.out.println(wf);
        set(wf,"i2", 100);
        System.out.println(wf);
        set(wf, "i3", 150);
        System.out.println(wf);
    }

    static void get(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        System.out.println(field.get(object));
    }

    static void set(Object object, String fieldName, Object newValue) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        System.out.println(field.get(object));
        field.set(object, newValue);
        System.out.println(field.get(object));
    }
}
