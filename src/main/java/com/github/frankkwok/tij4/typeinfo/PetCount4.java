package com.github.frankkwok.tij4.typeinfo;

import com.github.frankkwok.tij4.typeinfo.pets.Pet;
import com.github.frankkwok.tij4.typeinfo.pets.Pets;
import com.github.frankkwok.tij4.util.TypeCounter;

/**
 * Page 435
 * Exercise 11: Add Gerbil to the typeinfo.pets library and modify all the examples in this chapter to adapt to this
 * new class.
 *
 * @author Frank Kwok on 2017/5/10.
 */
public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            System.out.print(pet.getClass().getSimpleName() + " ");
            counter.count(pet);
        }
        System.out.println();
        System.out.println(counter);
    }
}
