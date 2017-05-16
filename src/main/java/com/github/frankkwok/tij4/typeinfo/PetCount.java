package com.github.frankkwok.tij4.typeinfo;

import com.github.frankkwok.tij4.typeinfo.pets.*;

import java.util.HashMap;

/**
 * Page 435
 * Exercise 11: Add Gerbil to the typeinfo.pets library and modify all the examples in this chapter to adapt to this
 * new class.
 *
 * @author Frank Kwok on 2017/5/10.
 */
public class PetCount {
    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }

    static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Cat) {
                counter.count("Cat");
            }
            if (pet instanceof Cymric) {
                counter.count("Cymric");
            }
            if (pet instanceof Dog) {
                counter.count("Dog");
            }
            if (pet instanceof EgyptianMau) {
                counter.count("EgyptianMau");
            }
            if (pet instanceof Gerbil) {
                counter.count("Gerbil");
            }
            if (pet instanceof Hamster) {
                counter.count("Hamster");
            }
            if (pet instanceof Manx) {
                counter.count("Manx");
            }
            if (pet instanceof Mouse) {
                counter.count("Mouse");
            }
            if (pet instanceof Mutt) {
                counter.count("Mutt");
            }
            if (pet instanceof Pet) {
                counter.count("Pet");
            }
            if (pet instanceof Pug) {
                counter.count("Pug");
            }
            if (pet instanceof Rat) {
                counter.count("Rat");
            }
            if (pet instanceof Rodent) {
                counter.count("Rodent");
            }
        }
        System.out.println();
        System.out.println(counter);
    }

    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            put(type, getOrDefault(type, 0) + 1);
        }
    }
}
