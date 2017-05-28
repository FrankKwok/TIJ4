package com.github.frankkwok.tij4.io;

import java.io.*;
import java.util.*;

abstract class Shape implements Serializable {
    static final int RED = 1, BLUE = 2, GREEN = 3;
    private int xPos, yPos, dimension;
    private static Random rand = new Random();
    private static int counter = 0;

    public abstract void setColor(int newColor);

    public abstract int getColor();

    public Shape(int xVal, int yVal, int dim) {
        xPos = xVal;
        yPos = yVal;
        dimension = dim;
    }

    public String toString() {
        return getClass() + "color[" + getColor() + "] xPos[" + xPos + "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }

    static Shape randomFactory() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0:
                return new Circle(xVal, yVal, dim);
            case 1:
                return new Square(xVal, yVal, dim);
            case 2:
                return new Line(xVal, yVal, dim);
        }
    }
}

class Circle extends Shape {
    private static int color = RED;

    Circle(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}

class Square extends Shape {
    private static int color;

    Square(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
        color = RED;
    }

    static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}

class Line extends Shape {
    private static int color = RED;

    Line(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}

public class StoreCADState {
    public static void main(String[] args) throws Exception {
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            shapes.add(Shape.randomFactory());
        for (int i = 0; i < 10; i++) {
            shapes.get(i).setColor(Shape.GREEN);
        }
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
        Circle.serializeStaticState(out);
        Square.serializeStaticState(out);
        Line.serializeStaticState(out);
        out.writeObject(shapes);
        System.out.println(shapes);
    }
}