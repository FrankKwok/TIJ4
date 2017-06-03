package com.github.frankkwok.tij4.concurrency;

import java.util.*;
import java.util.concurrent.*;

/**
 * Page 912
 * Exercise 33: Modify GreenhouseScheduler.java so that it uses a DelayQueue instead of a ScheduledExecutor.
 *
 * @author Frank Kwok on 2017/6/3.
 */
public class GreenhouseScheduler {
    private volatile boolean light = false;
    private volatile boolean water = false;
    private String thermostat = "Day";
    private Calendar lastTime = Calendar.getInstance();
    private float lastTemp = 65.0f;
    private int tempDirection = +1;
    private float lastHumidity = 50.0f;
    private int humidityDirection = +1;
    private Random rand = new Random(47);
    private List<DataPoint> data = Collections.synchronizedList(new ArrayList<DataPoint>());

    {
        lastTime.set(Calendar.MINUTE, 30);
        lastTime.set(Calendar.SECOND, 0);
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        GreenhouseScheduler gh = new GreenhouseScheduler();

        DelayQueue<DelayedTask> delayedTasks = new DelayQueue<>();
        int ACTIVE_TIME = 5000;
        delayedTasks.add(gh.new Terminate(ACTIVE_TIME));

        int BELL_PERIOD = 1000;
        for (int i = 0; i <= ACTIVE_TIME; i += BELL_PERIOD) {
            delayedTasks.add(gh.new Bell(i));
        }
        int NIGHT_PERIOD = 2000;
        for (int i = 0; i <= ACTIVE_TIME; i += NIGHT_PERIOD) {
            delayedTasks.add(gh.new ThermostatNight(i));
        }
        int LIGHT_ON_PERIOD = 200;
        for (int i = 0; i <= ACTIVE_TIME; i += LIGHT_ON_PERIOD) {
            delayedTasks.add(gh.new LightOn(i));
        }
        int LIGHT_OFF_PERIOD = 400;
        for (int i = 0; i <= ACTIVE_TIME; i += LIGHT_OFF_PERIOD) {
            delayedTasks.add(gh.new LightOff(i));
        }
        int WATER_ON_PERIOD = 600;
        for (int i = 0; i <= ACTIVE_TIME; i += WATER_ON_PERIOD) {
            delayedTasks.add(gh.new WaterOn(i));
        }
        int WATER_OFF_PERIOD = 800;
        for (int i = 0; i <= ACTIVE_TIME; i += WATER_OFF_PERIOD) {
            delayedTasks.add(gh.new WaterOff(i));
        }
        int DAY_PERIOD = 1400;
        for (int i = 0; i <= ACTIVE_TIME; i += DAY_PERIOD) {
            delayedTasks.add(gh.new ThermostatDay(i));
        }
        int COLLECT_DATA = 500;
        for (int i = 0; i <= ACTIVE_TIME; i += COLLECT_DATA) {
            delayedTasks.add(gh.new CollectData(i));
        }
        while (!delayedTasks.isEmpty()) {
            pool.execute(delayedTasks.take());
        }
    }

    public synchronized String getThermostat() {
        return thermostat;
    }

    public synchronized void setThermostat(String value) {
        thermostat = value;
    }

    class LightOn extends DelayedTask {
        LightOn(int delay) {
            super(delay);
        }

        @Override
        public void run() {
            System.out.println("Turning on lights");
            light = true;
        }
    }

    class LightOff extends DelayedTask {
        LightOff(int delay) {
            super(delay);
        }

        @Override
        public void run() {
            System.out.println("Turning off lights");
            light = false;
        }
    }

    class WaterOn extends DelayedTask {
        WaterOn(int delay) {
            super(delay);
        }

        @Override
        public void run() {
            System.out.println("Turning greenhouse water on");
            water = true;
        }
    }

    class WaterOff extends DelayedTask {
        WaterOff(int delay) {
            super(delay);
        }

        @Override
        public void run() {
            System.out.println("Turning greenhouse water off");
            water = false;
        }
    }

    class ThermostatNight extends DelayedTask {
        ThermostatNight(int delay) {
            super(delay);
        }

        @Override
        public void run() {
            System.out.println("Thermostat to night setting");
            setThermostat("Night");
        }
    }

    class ThermostatDay extends DelayedTask {
        ThermostatDay(int delay) {
            super(delay);
        }

        @Override
        public void run() {
            System.out.println("Thermostat to day setting");
            setThermostat("Day");
        }
    }

    class Bell extends DelayedTask {
        Bell(int delay) {
            super(delay);
        }

        @Override
        public void run() {
            System.out.println("Bing!");
        }
    }

    class Terminate extends DelayedTask {
        Terminate(int delay) {
            super(delay);
        }

        @Override
        public void run() {
            System.out.println("Terminating");
            new Thread(() -> {
                for (DataPoint d : data) {
                    System.out.println(d);
                }
            }).start();
        }
    }

    class CollectData extends DelayedTask {
        CollectData(int delay) {
            super(delay);
        }

        public void run() {
            System.out.println("Collecting data");
            synchronized (GreenhouseScheduler.this) {
                lastTime.set(Calendar.MINUTE, lastTime.get(Calendar.MINUTE) + 30);
                if (rand.nextInt(5) == 4) {
                    tempDirection = -tempDirection;
                }
                lastTemp = lastTemp + tempDirection * (1.0f + rand.nextFloat());
                if (rand.nextInt(5) == 4) {
                    humidityDirection = -humidityDirection;
                }
                lastHumidity = lastHumidity + humidityDirection * rand.nextFloat();
                data.add(new DataPoint((Calendar) lastTime.clone(), lastTemp, lastHumidity));
            }
        }
    }

    static class DataPoint {
        final Calendar time;
        final float temperature;
        final float humidity;

        DataPoint(Calendar d, float temp, float hum) {
            time = d;
            temperature = temp;
            humidity = hum;
        }

        public String toString() {
            return time.getTime() +
                    String.format(" temperature: %1$.1f humidity: %2$.2f", temperature, humidity);
        }
    }
}

abstract class DelayedTask implements Runnable, Delayed {
    private long trigger;

    DelayedTask(int delayInMillis) {
        trigger = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delayInMillis, TimeUnit.MILLISECONDS);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed otherObject) {
        DelayedTask other = (DelayedTask) otherObject;
        return Long.compare(trigger, other.trigger);
    }
}

