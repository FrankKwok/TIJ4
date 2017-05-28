package com.github.frankkwok.tij4.io;

import com.github.frankkwok.tij4.innerclasses.greenhouse.Event;
import com.github.frankkwok.tij4.innerclasses.greenhouse.GreenhouseControls;
import com.github.frankkwok.tij4.util.ResourceUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Page 11
 * Exercise 11: In the innerclasses/GreenhouseController.java example, GreenhouseController contains a hard-coded set of
 * events. Change the program so that it reads the events and their relative times from a text file, ((difficulty level
 * 8): Use a Factory Method design pattern to build the events—see Thinking in Patterns (with Java) at www.MindView.net.)
 *
 * @author Frank Kwok on 2017/5/28.
 */
public class GreenhouseController {
    public static void main(String[] args) {
        List<String> lines = ResourceUtils.readLines("events");
        GreenhouseControls gc = new GreenhouseControls();

        List<Event> events = new ArrayList<>();
        List<Event> restartEvents = new ArrayList<>();
        for (String line : lines) {
            String[] params = line.split("\\|");
            if (params.length == 2) {
                if (params[0].equals("Restart")) {
                    events.add(gc.new Restart(Integer.parseInt(params[1]), restartEvents.toArray(new Event[0])));
                    restartEvents.clear();
                } else {
                    events.add(createEvent(params[0], gc, Integer.parseInt(params[1])));
                }
            } else if (params.length == 3 && params[0].equals("Restart")) {
                restartEvents.add(createEvent(params[1], gc, Integer.parseInt(params[2])));
            }
        }
        for (Event e : events) {
            gc.addEvent(e);
        }
        gc.run();
    }

    private static Event createEvent(String simpleName, GreenhouseControls gc, long delay) {
        String className = GreenhouseControls.class.getName() + "$" + simpleName;
        try {
            Constructor<?> constructor = Class.forName(className).getDeclaredConstructor(GreenhouseControls.class, long.class);
            constructor.setAccessible(true);
            return (Event) constructor.newInstance(gc, delay);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
