package com.github.frankkwok.tij4.control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Page 128
 * Exercise 10: A vampire number has an even number of digits and is formed by multiplying a pair of numbers containing
 * half the number of digits of the result. The digits are taken from the original number in any order. Pairs of
 * trailing zeroes are not allowed. Examples include:
 * 1260 = 21 * 60
 * 1827 = 21 * 87
 * 2187 = 27 * 81
 * Write a program that finds all the 4-digit vampire numbers. (Suggested by Dan Forhan.)
 *
 * @author Frank Kwok on 2017/4/6.
 */
public class VampireNumber {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 10; i < 100; i++) {
            for (int j = 10; j < 100; j++) {
                int result = i * j;
                if (result >= 1000 && result < 10000) {
                    String[] rs = String.valueOf(result).split("");
                    String[] ij = (String.valueOf(i) + String.valueOf(j)).split("");
                    Arrays.sort(rs);
                    Arrays.sort(ij);
                    if (Arrays.equals(rs, ij)) {
                        if (!list.contains(i) || !list.contains(j)) {
                            System.out.println(result + " = " + i + " * " + j);
                            list.add(i);
                            list.add(j);
                        }
                    }
                }
            }
        }
    }
}
