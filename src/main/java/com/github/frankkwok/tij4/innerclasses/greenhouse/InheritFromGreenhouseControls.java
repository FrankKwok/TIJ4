package com.github.frankkwok.tij4.innerclasses.greenhouse;

/**
 * Page 291
 * Exercise 25: Inherit from GreenhouseControls in GreenhouseControls.java to add Event inner classes that turn water
 * mist generators on and off. Write a new version of GreenhouseController.java to use these new Event objects.
 *
 * @author Frank Kwok on 2017/4/14.
 */
public class InheritFromGreenhouseControls extends GreenhouseControls {
    private boolean waterMistGenerator = false;

    public class WaterMistGeneratorOn extends Event {
        public WaterMistGeneratorOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            waterMistGenerator = true;
        }

        @Override
        public String toString() {
            return "Greenhouse waterMistGenerator is on";
        }
    }

    public class WaterMistGeneratorOff extends Event {
        public WaterMistGeneratorOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            waterMistGenerator = false;
        }

        @Override
        public String toString() {
            return "Greenhouse waterMistGenerator is off";
        }
    }
}
