package com.github.frankkwok.tij4.polymorphism.music3;

import com.github.frankkwok.tij4.polymorphism.music.Note;

import java.util.Random;

/**
 * Page 224
 * Exercise 6: Change Music3.java so that what( ) becomes the root Object method toString( ). Try printing the
 * Instrument objects using System.out.println( ) (without any casting).
 * Exercise 7: Add a new type of Instrument to Music3.java and verify that polymorphism works for your new type.
 * Exercise 8: Modify Music3.java so that it randomly creates Instrument objects the way Shapes.java does.
 *
 * @author Frank Kwok on 2017/4/11.
 */
public class Music3 {
    private static final int MAX_LENGTH = 20;

    public static void main(String[] args) {
        tuneAll(instruments());
    }

    private static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    private static void tuneAll(Instrument[] e) {
        for (Instrument i : e) {
            tune(i);
            System.out.println(i);
            i.adjust();
            System.out.println();
        }
    }

    private static Instrument[] instruments() {
        Random random = new Random();
        int length = random.nextInt(MAX_LENGTH);
        Instrument[] instruments = new Instrument[length];
        for (int i = 0; i < instruments.length; i++) {
            instruments[i] = createInstrument();
        }
        return instruments;
    }

    private static Instrument createInstrument() {
        Random random = new Random();
        switch (random.nextInt(7)) {
            default:
            case 0:
                return new Instrument();
            case 1:
                return new Wind();
            case 2:
                return new Percussion();
            case 3:
                return new Stringed();
            case 4:
                return new Brass();
            case 5:
                return new Woodwind();
            case 6:
                return new Piano();
        }
    }
}

class Instrument {
    void play(Note n) {
        System.out.println("Instrument.play() " + n);
    }

    @Override
    public String toString() {
        return "Instrument";
    }

    void adjust() {
        System.out.println("Adjusting Instrument");
    }
}

class Wind extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Wind.play() " + n);
    }

    @Override
    public String toString() {
        return "Wind";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Wind");
    }
}

class Percussion extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }

    @Override
    public String toString() {
        return "Percussion";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Percussion");
    }
}

class Stringed extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }

    @Override
    public String toString() {
        return "Stringed";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Stringed");
    }
}

class Brass extends Wind {
    @Override
    void play(Note n) {
        System.out.println("Brass.play() " + n);
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Brass");
    }
}

class Woodwind extends Wind {
    @Override
    void play(Note n) {
        System.out.println("Woodwind.play() " + n);
    }

    @Override
    public String toString() {
        return "Woodwind";
    }
}

class Piano extends Instrument {
    @Override
    void play(Note n) {
        System.out.println("Piano.play() " + n);
    }

    @Override
    public String toString() {
        return "Piano";
    }

    @Override
    void adjust() {
        System.out.println("Adjusting Piano");
    }
}
