package com.github.frankkwok.tij4.polymorphism;

/**
 * Page 233
 * Exercise 15: Add a RectangularGlyph to PolyConstructors.java and demonstrate the problem described in this section.
 *
 * @author Frank Kwok on 2017/4/11.
 */
public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
        System.out.println();
        new RectangularGlyph(10, 15);
    }
}

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    private int radius = 1;

    RoundGlyph(int r) {
        radius = r;
        System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
    }

    void draw() {
        System.out.println("RoundGlyph.draw(), radius = " + radius);
    }
}

class RectangularGlyph extends Glyph {
    private int width = 2;
    private int height = 3;

    RectangularGlyph(int width, int height) {
        this.width = width;
        this.height = height;
        System.out.println("RectangularGlyph.RectangularGlyph(), width = " + width + ", height = " + height);
    }

    @Override
    void draw() {
        System.out.println("RectangularGlyph.draw(), width = " + width + ", height = " + height);
    }
}
