package com.github.frankkwok.tij4.arrays;

import com.github.frankkwok.tij4.util.CountingGenerator;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Page 577
 * Exercise 17: Create and test a Generator for BigDecimal, and ensure that it works with the Generated methods.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        CountingGenerator.BigDecimal gen = new CountingGenerator.BigDecimal();
        BigDecimal[] bigDecimals = new BigDecimal[10];
        for (int i = 0; i < bigDecimals.length; i++) {
            bigDecimals[i] = gen.next();
        }
        System.out.println(Arrays.toString(bigDecimals));
    }
}
