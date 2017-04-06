package com.github.frankkwok.tij4.control;

/**
 * Page 128
 * Exercise 9: A Fibonacci sequence is the sequence of numbers 1, 1, 2, 3, 5, 8, 13, 21, 34, and so on, where each
 * number (from the third on) is the sum of the previous two. Create a method that takes an integer as an argument and
 * displays that many Fibonacci numbers starting from the beginning, e.g., If you run java Fibonacci 5 (where Fibonacci
 * is the name of the class) the output will be: 1, 1, 2, 3, 5.
 *
 * @author Frank Kwok on 2017/4/6.
 */
public class Fibonacci {
    public static void main(String[] args) {
        if (args.length > 0) {
            int number = Integer.parseInt(args[0]);
            for (int i = 1; i <= number; i++) {
                System.out.print(fib(i) + " ");
            }
        }
    }

    private static int fib(int n) {
        if (n <= 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
