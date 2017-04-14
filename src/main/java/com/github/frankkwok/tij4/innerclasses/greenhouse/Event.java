package com.github.frankkwok.tij4.innerclasses.greenhouse;

/**
 * Page 290
 * Exercise 24: In GreenhouseControls.java, add Event inner classes that turn fans on and off. Configure
 * GreenhouseController.java to use these new Event objects.
 * <p>
 * Page 291
 * Exercise 25: Inherit from GreenhouseControls in GreenhouseControls.java to add Event inner classes that turn water
 * mist generators on and off. Write a new version of GreenhouseController.java to use these new Event objects.
 *
 * @author Frank Kwok on 2017/4/14.
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
