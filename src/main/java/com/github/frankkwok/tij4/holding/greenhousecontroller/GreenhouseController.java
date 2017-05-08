package com.github.frankkwok.tij4.holding.greenhousecontroller;

/**
 * Page 321
 * Exercise 13: In the innerclasses/GreenhouseController.java example, the class Controller uses an ArrayList. Change
 * the code to use a LinkedList instead, and use an Iterator to cycle through the set of events.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class GreenhouseController {
    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length == 1)
            gc.addEvent(
                    new GreenhouseControls.Terminate(
                            new Integer(args[0])));
        gc.run();
    }
}
