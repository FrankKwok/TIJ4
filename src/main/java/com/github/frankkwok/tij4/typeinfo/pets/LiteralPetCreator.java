package com.github.frankkwok.tij4.typeinfo.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Page 435
 * Exercise 11: Add Gerbil to the typeinfo.pets library and modify all the examples in this chapter to adapt to this
 * new class.
 *
 * @author Frank Kwok on 2017/5/10.
 */
public class LiteralPetCreator extends PetCreator {
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> allTypes =
            Collections.unmodifiableList(Arrays.asList(
                    Pet.class, Dog.class, Cat.class, Rodent.class,
                    Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
                    Cymric.class, Rat.class, Mouse.class, Hamster.class, Gerbil.class));

    private static final List<Class<? extends Pet>> types =
            allTypes.subList(allTypes.indexOf(Mutt.class),
                    allTypes.size());

    public List<Class<? extends Pet>> types() {
        return types;
    }
}
