package com.github.frankkwok.tij4.holding.shape;

/**
 * Page 327
 * Exercise 31: Modify polymorphism/shape/RandomShapeGenerator.java to make it Iterable. You’ll need to add a
 * constructor that takes the number of elements that you want the iterator to produce before stopping. Verify that it
 * works.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }

    public void erase() {
        System.out.println("Circle.erase()");
    }
}
