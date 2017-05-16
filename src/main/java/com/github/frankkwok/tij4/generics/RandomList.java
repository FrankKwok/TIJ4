package com.github.frankkwok.tij4.generics;

import java.util.ArrayList;
import java.util.Random;

/**
 * Page 467
 * Exercise 6: Use RandomList with two more types in addition to the one shown in main( ).
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<>();
    private Random rand = new Random();

    public static void main(String[] args) {
        RandomList<String> rs = new RandomList<>();
        for (String s : "The quick brown fox jumped over the lazy brown dog".split(" ")) {
            rs.add(s);
        }
        for (int i = 0; i < 11; i++) {
            System.out.print(rs.select() + " ");
        }
        System.out.println();

        RandomList<Integer> rsi = new RandomList<>();
        for (int i = 0; i < 10; i++) {
            rsi.add(i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(rsi.select() + " ");
        }
        System.out.println();

        RandomList<Float> rsf = new RandomList<>();
        for (int i = 0; i < 10; i++) {
            rsf.add(i * i / 0.75f);
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(rsf.select() + " ");
        }
    }

    public void add(T item) {
        storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }
}
