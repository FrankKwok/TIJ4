package com.github.frankkwok.tij4.holding.greenhousecontroller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Page 321
 * Exercise 13: In the innerclasses/GreenhouseController.java example, the class Controller uses an ArrayList. Change
 * the code to use a LinkedList instead, and use an Iterator to cycle through the set of events.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class Controller {
    private List<Event> eventList = new LinkedList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        while (eventList.size() > 0) {
            Iterator<Event> iterator = new LinkedList<>(eventList).iterator();
            while (iterator.hasNext()) {
                Event e = iterator.next();
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
            }
        }
    }
}
