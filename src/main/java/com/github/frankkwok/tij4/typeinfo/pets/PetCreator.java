package com.github.frankkwok.tij4.typeinfo.pets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Page 435
 * Exercise 11: Add Gerbil to the typeinfo.pets library and modify all the examples in this chapter to adapt to this
 * new class.
 *
 * @author Frank Kwok on 2017/5/10.
 */
public abstract class PetCreator {
    protected Random random = new Random();

    public abstract List<Class<? extends Pet>> types();

    public Pet randomPet() {
        int n = random.nextInt(types().size());
        try {
            return types().get(n).newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public Pet[] createArray(int size) {
        Pet[] result = new Pet[size];
        for (int i = 0; i < size; i++) {
            result[i] = randomPet();
        }
        return result;
    }

    public ArrayList<Pet> arrayList(int size) {
        ArrayList<Pet> result = new ArrayList<>();
        Collections.addAll(result, createArray(size));
        return result;
    }
}
