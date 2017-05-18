package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.typeinfo.FactoryPetCreator;
import com.github.frankkwok.tij4.typeinfo.pets.Pet;
import com.github.frankkwok.tij4.typeinfo.pets.PetCreator;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Page 40
 * Exercise 40: Add a speak( ) method to all the pets in typeinfo.pets. Modify Apply.java to call the speak( ) method
 * for a heterogeneous collection of Pet.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class ApplyTest {
    public static void main(String[] args) throws NoSuchMethodException {
        List<Pet> petList = new FactoryPetCreator().arrayList(10);
        Apply.apply(petList, Pet.class.getDeclaredMethod("speak"));
    }
}

class Apply {
    public static <T, S extends Iterable<? extends T>>
    void apply(S seq, Method f, Object... args) {
        try {
            for (T t : seq)
                f.invoke(t, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Shape {
    public void rotate() {
        System.out.println(this + " rotate");
    }

    public void resize(int newSize) {
        System.out.println(this + " resize " + newSize);
    }
}

class Square extends Shape {
}

class FilledList<T> extends ArrayList<T> {
    public FilledList(Class<? extends T> type, int size) {
        try {
            for (int i = 0; i < size; i++) {
                add(type.newInstance());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
