package com.github.frankkwok.tij4.generics;

import java.util.*;

/**
 * Page 482
 * Exercise 18: Following the form of BankTeller.java, create an example where BigFish eat LittleFish in the Ocean.
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class Ocean {
    public static void main(String[] args) {
        Random random = new Random();
        Queue<LittleFish> littleFish = new LinkedList<>();
        Generators.fill(littleFish, LittleFish::new, 15);
        List<BigFish> bigFish = new ArrayList<>();
        Generators.fill(bigFish, BigFish::new, 4);
        for (LittleFish lf : littleFish) {
            System.out.println(bigFish.get(random.nextInt(bigFish.size())) + " eat " + lf);
        }
    }
}

class Fish {
    private static long counter = 1;
    private final long id = counter++;

    public Fish() {
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}

class LittleFish extends Fish {

}

class BigFish extends Fish {

}
