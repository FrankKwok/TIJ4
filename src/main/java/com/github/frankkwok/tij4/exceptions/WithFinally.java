package com.github.frankkwok.tij4.exceptions;

/**
 * Page 357
 * Exercise 15: Show that WithFinally.java doesn’t fail by throwing a RuntimeException inside the try block.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class WithFinally {
    private static Switch sw = new Switch();

    public static void main(String[] args) {
        try {
            sw.on();
            // Code that can throw exceptions...
            OnOffSwitch.f();
        } catch (OnOffException1 e) {
            System.out.println("OnOffException1");
        } catch (OnOffException2 e) {
            System.out.println("OnOffException2");
        } finally {
            sw.off();
        }
    }
}
