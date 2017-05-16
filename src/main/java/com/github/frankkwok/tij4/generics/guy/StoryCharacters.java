package com.github.frankkwok.tij4.generics.guy;

/**
 * Page 471
 * Exercise 8: Following the form of the Coffee example, create a hierarchy of StoryCharacters from your favorite movie,
 * dividing them into GoodGuys and BadGuys. Create a generator for StoryCharacters, following the form of
 * CoffeeGenerator.
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class StoryCharacters {
    private static long counter = 0;

    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
