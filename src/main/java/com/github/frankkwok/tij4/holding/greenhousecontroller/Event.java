package com.github.frankkwok.tij4.holding.greenhousecontroller;

/**
 * Page 321
 * Exercise 13: In the innerclasses/GreenhouseController.java example, the class Controller uses an ArrayList. Change
 * the code to use a LinkedList instead, and use an Iterator to cycle through the set of events.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public abstract class Event {
    private long eventTime;
    protected final long delayTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start() {
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}
