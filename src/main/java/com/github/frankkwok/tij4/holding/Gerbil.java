package com.github.frankkwok.tij4.holding;

import java.util.*;

/**
 * Page 300
 * Exercise 1: Create a new class called Gerbil with an int gerbilNumber that’s initialized in the constructor. Give it
 * a method called hop( ) that displays which gerbil number this is, and that it’s hopping. Create an ArrayList and add
 * Gerbil objects to the List. Now use the get( ) method to move through the List and call hop( ) for each Gerbil.
 * <p>
 * Page 310
 * Exercise 8: Modify Exercise 1 so it uses an Iterator to move through the List while calling hop( ).
 * <p>
 * Page 319
 * Exercise 17: Take the Gerbil class in Exercise 1 and put it into a Map instead, associating each Gerbil’s name (e.g.
 * "Fuzzy" or "Spot") as a String (the key) for each Gerbil (the value) you put in the table. Get an Iterator for the
 * keySet( ) and use it to move through the Map, looking up the Gerbil for each key and printing out the key and telling
 * the Gerbil to hop( ).
 * Exercise 18: (3) Fill a HashMap with key-value pairs. Print the results to show ordering by hash code. Extract the
 * pairs, sort by key, and place the result into a LinkedHashMap. Show that the insertion order is maintained.
 *
 * @author Frank Kwok on 2017/4/23.
 */
public class Gerbil {
    private int gerbilNumber;

    Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    public static void main(String[] args) {
        Map<String, Gerbil> gerbilMap = new HashMap<>();
        gerbilMap.put("Fuzzy", new Gerbil(3));
        gerbilMap.put("Spot", new Gerbil(5));

        Iterator<String> iterator = gerbilMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("Key = " + key + ", Value = " + gerbilMap.get(key));
        }

        System.out.println("Change to LinkedHashMap: ");
        gerbilMap = new LinkedHashMap<>();
        gerbilMap.put("Fuzzy", new Gerbil(3));
        gerbilMap.put("Spot", new Gerbil(5));

        iterator = gerbilMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println("Key = " + key + ", Value = " + gerbilMap.get(key));
        }
    }

    void hop() {
        System.out.println("gerbilNumber = " + gerbilNumber);
    }
}
