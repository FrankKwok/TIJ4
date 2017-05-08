package com.github.frankkwok.tij4.holding.shape;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Page 327
 * Exercise 31: Modify polymorphism/shape/RandomShapeGenerator.java to make it Iterable. You’ll need to add a
 * constructor that takes the number of elements that you want the iterator to produce before stopping. Verify that it
 * works.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class RandomShapeGenerator implements Iterable<Shape> {
    private Random rand = new Random();
    private int size;

    public RandomShapeGenerator(int size) {
        this.size = size;
    }

    public static void main(String[] args) {
        RandomShapeGenerator rsg = new RandomShapeGenerator(5);
        for (Shape s : rsg) {
            System.out.println(s);
        }
    }

    @Override
    public Iterator<Shape> iterator() {
        return new Iterator<Shape>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Shape next() {
                if (hasNext()) {
                    index++;
                    switch (rand.nextInt(3)) {
                        default:
                        case 0:
                            return new Circle();
                        case 1:
                            return new Square();
                        case 2:
                            return new Triangle();
                    }
                } else {
                    throw new NoSuchElementException();
                }
            }
        };
    }
}
