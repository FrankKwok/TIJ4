package com.github.frankkwok.tij4.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Page 506
 * Exercise 26: Demonstrate array covariance using Numbers and Integers.
 * Exercise 27: Show that covariance doesn’t work with Lists, using Numbers and Integers, then introduce wildcards.
 *
 * @author Frank Kwok on 2017/5/17.
 */
public class NumberCovariance {
    public static void main(String[] args) {
        Number[] numbers = new Integer[5];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }
        System.out.println(Arrays.toString(numbers));

//        List<Number> numberList = new ArrayList<Integer>();
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            integerList.add(i);
        }
        List<? extends Number> numberList = integerList;
        System.out.println(numberList);

    }
}
