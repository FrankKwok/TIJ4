package com.github.frankkwok.tij4.holding;

import java.util.*;

/**
 * Page 305
 * Exercise 4: Create a generator class that produces character names (as String objects) from your favorite movie (you
 * can use Snow White or Star Wars as a fallback) each time you call next( ), and loops around to the beginning of the
 * character list when it runs out of names. Use this generator to fill an array, an ArrayList, a LinkedList, a HashSet,
 * a LinkedHashSet, and a TreeSet, then print each container.
 *
 * @author Frank Kwok on 2017/4/23.
 */
public class StringGenerator {
    private int i = 0;
    private String[] seeds = new String[]{
            "The Shawshank Redemption", "The Godfather",
            "The Dark Knight", "Fight Club",
            "Snow White", "Star Wars"
    };

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        fill(al);
        System.out.println(al);

        LinkedList<String> ll = new LinkedList<>();
        fill(ll);
        System.out.println(ll);

        HashSet<String> hs = new HashSet<>();
        fill(hs);
        System.out.println(hs);

        TreeSet<String> ts = new TreeSet<>();
        fill(ts);
        System.out.println(ts);

        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        fill(lhs);
        System.out.println(lhs);
    }

    private static void fill(Collection<String> c) {
        StringGenerator sg = new StringGenerator();
        for (int i = 0; i < 9; i++) {
            c.add(sg.next());
        }
    }

    private String next() {
        return seeds[i++ % seeds.length];
    }
}
