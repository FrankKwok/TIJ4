package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.typeinfo.pets.Person;
import com.github.frankkwok.tij4.typeinfo.pets.Pet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Page 474
 * Exercise 12: Repeat the previous exercise using explicit type specification.
 * <p>
 * Since Java now can inference more, we don't need New.java
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class ExplicitTypeSpecification {
    static void f(Map<Person, List<Pet>> petPeople) {
        System.out.println(petPeople);
    }
    public static void main(String[] args) {
        f(new HashMap<>());
    }
}
