package com.github.frankkwok.tij4.typoinfo.factory;

/**
 * Page 435
 * Exercise 12: Use TypeCounter with the CoffeeGenerator.java class in the Generics chapter.
 * Exercise 13: Use TypeCounter with the RegisteredFactories.java example in this chapter.
 * <p>
 * Page 438
 * Exercise 14: A constructor is a kind of factory method. Modify RegisteredFactories.java so that instead of using an
 * explicit factory, the class object is stored in the List, and newlnstance( ) is used to create each object.
 * <p>
 * Page 452
 * Exercise 24: Add Null Objects to RegisteredFactories.java.
 *
 * @author Frank Kwok on 2017/5/11.
 */
public interface Factory<T> {
    T create();
}
