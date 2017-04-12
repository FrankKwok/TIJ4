package com.github.frankkwok.tij4.interfaces.musics;

import com.github.frankkwok.tij4.polymorphism.music.Note;

/**
 * Page 247
 * Exercise 9: Refactor Musics.java by moving the common methods in Wind, Percussion and Stringed into an abstract class.
 * Exercise 10: Modify Musics.java by adding a Playable interface. Move the play( ) declaration from Instrument to
 * Playable. Add Playable to the derived classes by including it in the implement s list. Change tune( ) so that it
 * takes a Playable instead of an Instrument.
 *
 * @author Frank Kwok on 2017/4/12.
 */
public class Musics {
    public static void main(String[] args) {
        Instrument[] instruments = new Instrument[]{
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        for (Instrument i : instruments) {
            tune(i);
            i.adjust();
            System.out.println();
        }
    }

    private static void tune(Playable playable) {
        playable.play(Note.C_SHARP);
    }
}

abstract class Instrument implements Playable {
    @Override
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

interface Playable {
    void play(Note note);
}
