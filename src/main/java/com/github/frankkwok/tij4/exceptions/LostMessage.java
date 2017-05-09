package com.github.frankkwok.tij4.exceptions;

/**
 * Page 360
 * Exercise 18: Add a second level of exception loss to LostMessage.java so that the HoHumException is itself replaced
 * by a third exception.
 * Exercise 19: Repair the problem in LostMessage.java by guarding the call in the finally clause.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class LostMessage {
    public static void main(String[] args) {
        try {
            LostMessage lm = new LostMessage();
            try {
                lm.f();
            } finally {
                try {
                    lm.dispose();
                } catch (HoHumException e) {
                    e.printStackTrace();
                } finally {
//                    throw new RuntimeException();

                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void f() throws VeryImportantException {
        throw new VeryImportantException();
    }

    void dispose() throws HoHumException {
        throw new HoHumException();
    }
}

class VeryImportantException extends Exception {
    public String toString() {
        return "A very important exception!";
    }
}

class HoHumException extends Exception {
    public String toString() {
        return "A trivial exception";
    }
}
