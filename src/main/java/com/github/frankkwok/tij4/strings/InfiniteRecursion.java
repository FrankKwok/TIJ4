package com.github.frankkwok.tij4.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Page 382
 * Exercise 2: Repair InfiniteRecursion.java.
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class InfiniteRecursion {
    public static void main(String[] args) {
        List<InfiniteRecursion> v =
                new ArrayList<>();
        for (int i = 0; i < 10; i++)
            v.add(new InfiniteRecursion());
        System.out.println(v);
    }

    @Override
    public String toString() {
        return " InfiniteRecursion address: " + super.toString() + "\n";
    }
}
