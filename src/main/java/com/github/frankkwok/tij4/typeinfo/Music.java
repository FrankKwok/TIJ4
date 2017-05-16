package com.github.frankkwok.tij4.typeinfo;

import com.github.frankkwok.tij4.polymorphism.music.Note;

/**
 * Page 458
 * Exercise 26: Implement clearSpitValve( ) as described in the summary.
 *
 * @author Frank Kwok on 2017/5/15.
 */
public class Music {
    public static void main(String[] args) {
        Instrument[] instruments = new Instrument[]{
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        for (Instrument i : instruments) {
            i.play(Note.C_SHARP);
            i.adjust();
            if (i instanceof Wind) {
                ((Wind)i).clearSpitValve();
            }
            System.out.println();
        }
    }
}

abstract class Instrument {
    public void play(Note note) {
        System.out.println(this + ".play() " + note);
    }

    void adjust() {
        System.out.println(this + ".adjust()");
    }

    @Override
    public abstract String toString();
}

class Wind extends Instrument {
    @Override
    public String toString() {
        return "Wind";
    }

    public void clearSpitValve() {
        System.out.println("Wind.clearSpitValve");
    }
}

class Percussion extends Instrument {
    @Override
    public String toString() {
        return "Percussion";
    }
}

class Stringed extends Instrument {
    @Override
    public String toString() {
        return "Stringed";
    }
}

class Brass extends Wind {
    @Override
    public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {
    @Override
    public String toString() {
        return "Woodwind";
    }
}