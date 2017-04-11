package com.github.frankkwok.tij4.polymorphism.shape;

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
public class Pentagon extends Shape {
    @Override
    public void draw() {
        System.out.println("Pentagon.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Pentagon.erase()");
    }

    @Override
    public void print() {
        System.out.println("Pentagon.print()");
    }
}
