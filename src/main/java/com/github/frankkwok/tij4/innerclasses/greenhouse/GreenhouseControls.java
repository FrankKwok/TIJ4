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
public class GreenhouseControls extends Controller {
    private boolean light = false;
    private boolean water = false;
    private String thermostat = "Day";
    private boolean fans = false;

    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        public void action() {
            light = true;
        }

        public String toString() {
            return "Light is on";
        }
    }

    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }

        public void action() {
            light = false;
        }

        public String toString() {
            return "Light is off";
        }
    }

    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        public void action() {
            water = true;
        }

        public String toString() {
            return "Greenhouse water is on";
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        public void action() {
            water = false;
        }

        public String toString() {
            return "Greenhouse water is off";
        }
    }

    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        public void action() {
            thermostat = "Night";
        }

        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        public void action() {
            thermostat = "Day";
        }

        public String toString() {
            return "Thermostat on day setting";
        }
    }

    public class FansOn extends Event {
        public FansOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            fans = true;
        }

        @Override
        public String toString() {
            return "Fans is on";
        }
    }

    public class FansOff extends Event {
        public FansOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            fans = false;
        }

        @Override
        public String toString() {
            return "Fans is off";
        }
    }

    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        public void action() {
            addEvent(new Bell(delayTime));
        }

        public String toString() {
            return "Bing!";
        }
    }

    public class Restart extends Event {
        private Event[] eventList;

        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event e : eventList)
                addEvent(e);
        }

        public void action() {
            for (Event e : eventList) {
                e.start();
                addEvent(e);
            }
            start();
            addEvent(this);
        }

        public String toString() {
            return "Restarting system";
        }
    }

    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }

        public void action() {
            System.exit(0);
        }

        public String toString() {
            return "Terminating";
        }
    }
}
