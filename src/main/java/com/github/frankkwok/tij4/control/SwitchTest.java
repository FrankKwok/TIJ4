package com.github.frankkwok.tij4.control;

/**
 * Page 128
 * Exercise 8: Create a switch statement that prints a message for each case, and put the switch inside a for loop that
 * tries each case. Put a break after each case and test it, then remove the breaks and see what happens.
 *
 * @author Frank Kwok on 2017/4/6.
 */
public class SwitchTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    System.out.println("zero");
                    break;
                case 1:
                    System.out.println("one");
                    break;
                case 2:
                    System.out.println("two");
                    break;
                case 3:
                    System.out.println("three");
                    break;
                case 4:
                    System.out.println("four");
                    break;
            }
        }
    }
}
