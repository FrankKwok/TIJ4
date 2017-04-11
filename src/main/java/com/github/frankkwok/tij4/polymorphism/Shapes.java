package com.github.frankkwok.tij4.polymorphism;

import com.github.frankkwok.tij4.polymorphism.shape.RandomShapeGenerator;
import com.github.frankkwok.tij4.polymorphism.shape.Shape;

/**
 * Page 211
 * Exercise 2: Add the @Override annotation to the shapes example.
 * Exercise 3: Add a new method in the base class of Shapes.java that prints a message, but don’t override it in the
 * derived classes. Explain what happens. Now override it in one of the derived classes but not the others, and see what
 * happens. Finally, override it in all the derived classes.
 * Exercise 4: Add a new type of Shape to Shapes.java and verify in main( ) that polymorphism works for your new type as
 * it does in the old types.
 *
 * @author Frank Kwok on 2017/4/11.
 */
public class Shapes {
    private static RandomShapeGenerator gen = new RandomShapeGenerator();

    public static void main(String[] args) {
        Shape[] shapes = new Shape[9];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = gen.next();
        }
        for (Shape s : shapes) {
            s.draw();
            s.print();
            System.out.println();
        }
    }
}
