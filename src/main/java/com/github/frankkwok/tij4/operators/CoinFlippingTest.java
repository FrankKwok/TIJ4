package com.github.frankkwok.tij4.operators;

/**
 * Page 94
 * Exercise 7: Write a program that simulates coin-flipping.
 *
 * @author Frank Kwok on 2017/4/5.
 */
public class CoinFlippingTest {
    public static void main(String[] args) {
        if (Math.random() < 0.5) {
            System.out.println("正");
        } else {
            System.out.println("反");
        }
    }
}
