package com.github.frankkwok.tij4.typeinfo;

import java.util.Arrays;
import java.util.List;

/**
 * Page 420
 * Exercise 3: Add Rhomboid to Shapes.java. Create a Rhomboid, upcast it to a Shape, then downcast it back to a
 * Rhomboid. Try downcasting to a Circle and see what happens.
 * Exercise 4: Modify the previous exercise so that it uses instanceof to check the type before performing the downcast.
 * <p>
 * Page 421
 * Exercise 5: Implement a rotate(Shape) method in Shapes.java, such that it checks to see if it is rotating a Circle
 * (and, if so, doesn’t perform the operation).
 * Exercise 6: Modify Shapes.java so that it can "highlight" (set a flag in) all shapes of a particular type. The
 * toString( ) method for each derived Shape should indicate whether that Shape is "highlighted."
 *
 * @author Frank Kwok on 2017/5/9.
 */
public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle(), new Rhomboid());
        for (Shape shape : shapeList) {
            highLight(shape);
            shape.draw();
            if (shape instanceof Rhomboid) {
                Rhomboid rhomboid = (Rhomboid) shape;
                System.out.println(rhomboid.toString());
            }
        }
    }

    static void rotate(Shape shape) {
        if (shape instanceof Circle) {
            System.out.println("Do nothing");
        } else {
            System.out.println("rotate " + shape);
        }
    }

    static void highLight(Shape shape) {
        shape.setHighLight(true);
    }
}

abstract class Shape {
    protected boolean highLight;

    void setHighLight(boolean highLight) {
        this.highLight = highLight;
    }

    void draw() {
        System.out.println(this + ".draw()");
    }

    abstract public String toString();
}

class Circle extends Shape {
    public String toString() {
        return "highlight = " + highLight + " Circle";
    }
}

class Square extends Shape {
    public String toString() {
        return "highlight = " + highLight + " Square";
    }
}

class Triangle extends Shape {
    public String toString() {
        return "highlight = " + highLight + " Triangle";
    }
}

class Rhomboid extends Shape {
    @Override
    public String toString() {
        return "highlight = " + highLight + " Rhomboid";
    }
}
