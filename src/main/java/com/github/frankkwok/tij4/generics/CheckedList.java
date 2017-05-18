package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.generics.coffee.Americano;
import com.github.frankkwok.tij4.generics.coffee.Cappuccino;
import com.github.frankkwok.tij4.generics.coffee.Coffee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Page 529
 * Exercise 35: Modify CheckedList.java so that it uses the Coffee classes defined in this chapter.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class CheckedList {
    @SuppressWarnings("unchecked")
    static void oldStyleMethod(List probablyDogs) {
        probablyDogs.add(new Cappuccino());
    }

    public static void main(String[] args) {
        List<Americano> americanos1 = new ArrayList<>();
        oldStyleMethod(americanos1);
        List<Americano> americanos2 = Collections.checkedList(new ArrayList<>(), Americano.class);
        try {
            oldStyleMethod(americanos2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Coffee> coffees = Collections.checkedList(
                new ArrayList<>(), Coffee.class);
        coffees.add(new Americano());
        coffees.add(new Cappuccino());
    }
}
