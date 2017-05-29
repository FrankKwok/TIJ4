package com.github.frankkwok.tij4.enumerated;

/**
 * Page 759
 * Exercise 3: Add a new Course to Course.java and demonstrate that it works in Meal.java.
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("---");
        }
    }
}
