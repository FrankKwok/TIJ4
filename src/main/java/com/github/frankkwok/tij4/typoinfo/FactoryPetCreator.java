package com.github.frankkwok.tij4.typoinfo;

import com.github.frankkwok.tij4.typoinfo.factory.Factory;
import com.github.frankkwok.tij4.typoinfo.pets.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Page 438
 * Exercise 15: Implement a new PetCreator using Registered Factories, and modify the Pets Facade so that it uses this
 * one instead of the other two. Ensure that the rest of the examples that use Pets .Java still work correctly.
 *
 * @author Frank Kwok on 2017/5/11.
 */
public class FactoryPetCreator extends PetCreator {
    static List<Factory<? extends Pet>> petFactories = new ArrayList<>();

    static {
        petFactories.add(Mutt::new);
        petFactories.add(Pug::new);
        petFactories.add(EgyptianMau::new);
        petFactories.add(Manx::new);
        petFactories.add(Cymric::new);
        petFactories.add(Rat::new);
        petFactories.add(Mouse::new);
        petFactories.add(Hamster::new);
        petFactories.add(Gerbil::new);
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return Arrays.asList(Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
                Cymric.class, Rat.class, Mouse.class, Hamster.class, Gerbil.class);
    }

    @Override
    public Pet randomPet() {
        int n = random.nextInt(petFactories.size());
        return petFactories.get(n).create();
    }
}
