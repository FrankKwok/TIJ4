package com.github.frankkwok.tij4.operators;

/**
 * Page 93
 * <p>
 * Exercise 5: Create a class called Dog containing two Strings: name and says. In main( ), create two dog objects with
 * names “spot” (who says, “Ruff!”) and “scruffy” (who says, “Wurf!”). Then display their names and what they say.
 * Exercise 6: Following Exercise 5, create a new Dog reference and assign it to spot’s object. Test for comparison
 * using == and equals( ) for all references.
 *
 * @author Frank Kwok on 2017/4/5.
 */
public class DogTest {
    public static void main(String[] args) {
        Dog spot = new Dog();
        spot.name = "spot";
        spot.says = "Ruff!";
        System.out.println("name=" + spot.name + ", says=" + spot.says);
        Dog scruffy = new Dog();
        scruffy.name = "scruffy";
        scruffy.says = "Wurf!";
        System.out.println("name=" + scruffy.name + ", says=" + scruffy.says);
        System.out.println();

        Dog dog = spot;
        System.out.println("spot==scruffy: " + (spot == scruffy));
        System.out.println("spot.equals(scruffy): " + spot.equals(scruffy));
        System.out.println("spot==dog: " + (spot == dog));
        System.out.println("spot.equals(dog): " + spot.equals(dog));
        System.out.println("scruffy==dog: " + (scruffy == dog));
        System.out.println("scruffy.equals(dog): " + scruffy.equals(dog));
    }
}

class Dog {
    String name;
    String says;
}
