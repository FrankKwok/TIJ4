package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.typeinfo.pets.Person;
import com.github.frankkwok.tij4.typeinfo.pets.Pet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Page 473
 * Exercise 11: Test New.java by creating your own classes and ensuring that New will work properly with them.
 * Generics
 * <p>
 * Since Java now can inference constructor, we don't need New.java
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class NewTest {
    public static void main(String[] args) {
        Map<Person, List<? extends Pet>> map = new HashMap<>();
        System.out.println(map);
    }
}
