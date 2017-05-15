package com.github.frankkwok.tij4.typoinfo;

import com.github.frankkwok.tij4.typoinfo.pets.LiteralPetCreator;
import com.github.frankkwok.tij4.typoinfo.pets.Pet;
import com.github.frankkwok.tij4.typoinfo.pets.Pets;

import java.util.LinkedHashMap;

/**
 * Page 435
 * Exercise 11: Add Gerbil to the typeinfo.pets library and modify all the examples in this chapter to adapt to this
 * new class.
 *
 * @author Frank Kwok on 2017/5/10.
 */
public class PetCount3 {
    public static void main(String[] args) {
        PetCounter petCounter = new PetCounter();
        for (Pet pet : Pets.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            petCounter.count(pet);
        }
        System.out.println();
        System.out.println(petCounter);
    }

    static class PetCounter extends LinkedHashMap<String, Integer> {
        public void count(Pet pet) {
            for (Class<? extends Pet> type : LiteralPetCreator.allTypes) {
                if (type.isInstance(pet)) {
                    String key = type.getSimpleName();
                    put(key, getOrDefault(key, 0) + 1);
                }
            }
        }
    }
}
