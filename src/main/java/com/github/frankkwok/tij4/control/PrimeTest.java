package com.github.frankkwok.tij4.control;

/**
 * Page 118
 * Exercise 4: Write a program that uses two nested for loops and the modulus operator (%) to detect and print prime
 * numbers (integral numbers that are not evenly divisible by any other numbers except for themselves and 1).
 *
 * @author Frank Kwok on 2017/4/6.
 */
public class PrimeTest {
    public static void main(String[] args) {
        int number = 100;

        for (int i = 2; i < number; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                }
            }
            if (isPrime) {
                System.out.println(i);
            }
        }
    }
}
