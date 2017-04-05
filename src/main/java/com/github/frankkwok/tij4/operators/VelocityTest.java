package com.github.frankkwok.tij4.operators;

/**
 * Page 90
 * <p>
 * Exercise 4: Write a program that calculates velocity using a constant distance and a constant time.
 *
 * @author Frank Kwok on 2017/4/5.
 */
public class VelocityTest {
    public static void main(String[] args) {
        double distance = 9.8;
        double time = 7.6;
        System.out.println("distance = " + distance);
        System.out.println("time = " + time);
        System.out.println("velocity = " + (distance / time));
    }
}
