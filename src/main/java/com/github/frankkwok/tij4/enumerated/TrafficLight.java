package com.github.frankkwok.tij4.enumerated;

import static com.github.frankkwok.tij4.enumerated.Signal.*;

/**
 * Page 751
 * Exercise 1: Use a static import to modify TrafficLight.java so you don’t have to qualify the enum instances.
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class TrafficLight {
    private Signal color = RED;

    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(light);
            light.change();
        }
    }

    public void change() {
        switch (color) {
            case RED:
                color = GREEN;
                break;
            case GREEN:
                color = YELLOW;
                break;
            case YELLOW:
                color = RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }
}

enum Signal {
    GREEN, YELLOW, RED,
}