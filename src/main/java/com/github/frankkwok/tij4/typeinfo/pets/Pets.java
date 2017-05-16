package com.github.frankkwok.tij4.typeinfo.pets;

import com.github.frankkwok.tij4.typeinfo.FactoryPetCreator;

import java.util.ArrayList;

/**
 * Page 435
 * Exercise 11: Add Gerbil to the typeinfo.pets library and modify all the examples in this chapter to adapt to this
 * new class.
 * <p>
 * Page 438
 * Exercise 15: Implement a new PetCreator using Registered Factories, and modify the Pets Facade so that it uses this
 * one instead of the other two. Ensure that the rest of the examples that use Pets .Java still work correctly.
 *
 * @author Frank Kwok on 2017/5/10.
 */
public class Pets {
    public static final PetCreator creator =
            new FactoryPetCreator();

    public static Pet randomPet() {
        return creator.randomPet();
    }

    public static Pet[] createArray(int size) {
        return creator.createArray(size);
    }

    public static ArrayList<Pet> arrayList(int size) {
        return creator.arrayList(size);
    }
}
