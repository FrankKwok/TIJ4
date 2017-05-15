package com.github.frankkwok.tij4.typoinfo.pets;

import java.util.ArrayList;
import java.util.List;

/**
 * Page 435
 * Exercise 11: Add Gerbil to the typeinfo.pets library and modify all the examples in this chapter to adapt to this
 * new class.
 *
 * @author Frank Kwok on 2017/5/10.
 */
public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = new String[]{
            "com.github.frankkwok.tij4.typoinfo.pets.Mutt",
            "com.github.frankkwok.tij4.typoinfo.pets.Pug",
            "com.github.frankkwok.tij4.typoinfo.pets.EgyptianMau",
            "com.github.frankkwok.tij4.typoinfo.pets.Manx",
            "com.github.frankkwok.tij4.typoinfo.pets.Cymric",
            "com.github.frankkwok.tij4.typoinfo.pets.Rat",
            "com.github.frankkwok.tij4.typoinfo.pets.Mouse",
            "com.github.frankkwok.tij4.typoinfo.pets.Hamster",
            "com.github.frankkwok.tij4.typoinfo.pets.Gerbil"
    };

    static {
        loadClasses();
    }

    @SuppressWarnings("unchecked")
    private static void loadClasses() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
