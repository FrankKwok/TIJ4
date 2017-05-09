package com.github.frankkwok.tij4.exceptions;

/**
 * Page 357
 * Exercise 14: Show that OnOffSwitch.java can fail by throwing a RuntimeException inside the try block.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class OnOffSwitch {
    private static Switch sw = new Switch();

    public static void f()
            throws OnOffException1, OnOffException2 {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            f();
            sw.off();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
            sw.off();
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
            sw.off();
        }
    }
}

class Switch {
    private boolean state = false;

    public boolean read() {
        return state;
    }

    public void on() {
        state = true;
        System.out.println(this);
    }

    public void off() {
        state = false;
        System.out.println(this);
    }

    public String toString() {
        return state ? "on" : "off";
    }
}

class OnOffException1 extends Exception {
}

class OnOffException2 extends Exception {
}
