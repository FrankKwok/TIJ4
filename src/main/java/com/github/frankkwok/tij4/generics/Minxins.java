package com.github.frankkwok.tij4.generics;

import java.awt.*;
import java.util.Date;

/**
 * Page 533
 * Exercise 37: Add a new mixin class Colored to Mixins.java, mix it into Mixin, and show that it works.
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class Minxins {
    public static void main(String[] args) {
        Mixin mixin1 = new Mixin(), mixin2 = new Mixin();
        mixin1.set("test string 1");
        mixin2.set("test string 2");
        System.out.println(mixin1.get() + " " +
                mixin1.getStamp() + " " + mixin1.getSerialNumber() + " " + mixin1.getColor());
        System.out.println(mixin2.get() + " " +
                mixin2.getStamp() + " " + mixin2.getSerialNumber() + " " + mixin2.getColor());
    }
}

interface TimeStamped {
    long getStamp();
}

class TimeStampedImp implements TimeStamped {
    private final long timeStamp;

    public TimeStampedImp() {
        timeStamp = new Date().getTime();
    }

    public long getStamp() {
        return timeStamp;
    }
}

interface SerialNumbered {
    long getSerialNumber();
}

class SerialNumberedImp implements SerialNumbered {
    private static long counter = 1;
    private final long serialNumber = counter++;

    public long getSerialNumber() {
        return serialNumber;
    }
}

interface Basic {
    void set(String val);

    String get();
}

class BasicImp implements Basic {
    private String value;

    public void set(String val) {
        value = val;
    }

    public String get() {
        return value;
    }
}

interface Colored {
    Color getColor();
}

class ColoredImpl implements Colored {
    @Override
    public Color getColor() {
        return Color.BLACK;
    }
}

class Mixin extends BasicImp implements TimeStamped, SerialNumbered, Colored {
    private TimeStamped timeStamp = new TimeStampedImp();
    private SerialNumbered serialNumber = new SerialNumberedImp();
    private ColoredImpl colored = new ColoredImpl();

    public long getStamp() {
        return timeStamp.getStamp();
    }

    public long getSerialNumber() {
        return serialNumber.getSerialNumber();
    }

    @Override
    public Color getColor() {
        return colored.getColor();
    }
}
