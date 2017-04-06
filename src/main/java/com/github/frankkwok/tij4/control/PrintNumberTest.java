package com.github.frankkwok.tij4.control;

/**
 * Page 118
 * Exercise 1: Write a program that prints values from 1 to 100.
 * <p>
 * Page 122
 * Exercise 7: Modify Exercise 1 so that the program exits by using the break keyword at value 99. Try using return instead.
 *
 * @author Frank Kwok on 2017/4/6.
 */
public class PrintNumberTest {
    public static void main(String[] args) {
        // while loop
        int i = 1;
        while (i <= 100) {
            System.out.println(i++);
        }
        System.out.println();
        // do-while loop
        i = 1;
        do {
            System.out.println(i++);
        } while (i <= 100);
        System.out.println();
        // for loop
        for (i = 1; i <= 100; i++) {
            System.out.println(i);
        }

        // break
        for (i = 1; i <= 100; i++) {
            if (i == 99) {
                break;
            }
            System.out.println(i);
        }

        // return
        for (i = 1; i <= 100; i++) {
            if (i == 99) {
                return;
            }
            System.out.println(i);
        }
    }
}
