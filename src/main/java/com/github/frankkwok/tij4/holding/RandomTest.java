package com.github.frankkwok.tij4.holding;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Page 320
 * Exercise 23: Starting with Statistics.java, create a program that runs the test repeatedly and looks to see if any
 * one number tends to appear more than the others in the results.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10000; i++) {
            int r = random.nextInt(20);
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        System.out.println(map);
    }
}
