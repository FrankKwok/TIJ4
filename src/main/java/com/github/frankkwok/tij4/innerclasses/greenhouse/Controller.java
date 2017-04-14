package com.github.frankkwok.tij4.innerclasses.greenhouse;

import java.util.ArrayList;
import java.util.List;

/**
 * Page 290
 * Exercise 24: In GreenhouseControls.java, add Event inner classes that turn fans on and off. Configure
 * GreenhouseController.java to use these new Event objects.
 *
 * @author Frank Kwok on 2017/4/14.
 */
public class Controller {
    private List<Event> eventList = new ArrayList<>();

    public void addEvent(Event c) {
        eventList.add(c);
    }

    public void run() {
        while (eventList.size() > 0)
            for (Event e : new ArrayList<>(eventList))
                if (e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
    }
}
