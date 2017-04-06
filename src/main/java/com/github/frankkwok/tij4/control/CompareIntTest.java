package com.github.frankkwok.tij4.control;

import java.util.Random;

/**
 * Page 118
 * Exercise 2: Write a program that generates 25 random int values. For each value, use an if-else statement to classify
 * it as greater than, less than, or equal to a second randomly generated value.
 * Exercise 3: Modify Exercise 2 so that your code is surrounded by an “infinite” while loop. It will then run until you
 * interrupt it from the keyboard (typically by pressing Control-C).
 *
 * @author Frank Kwok on 2017/4/6.
 */
public class CompareIntTest {
    public static void main(String[] args) {
        Random random = new Random();

        int first = random.nextInt();
        int second = random.nextInt();

        for (int i = 0; i < 25; i++) {
            if (first > second) {
                System.out.println(first + " > " + second);
            } else if (first == second) {
                System.out.println(first + " = " + second);
            } else {
                System.out.println(first + " < " + second);
            }
            first = second;
            second = random.nextInt();
        }

        System.out.println();
        while (true) {
            if (first > second) {
                System.out.println(first + " > " + second);
            } else if (first == second) {
                System.out.println(first + " = " + second);
            } else {
                System.out.println(first + " < " + second);
            }
            first = second;
            second = random.nextInt();
        }
    }
}
