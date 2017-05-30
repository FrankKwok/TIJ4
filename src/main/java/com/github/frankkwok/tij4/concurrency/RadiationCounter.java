package com.github.frankkwok.tij4.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Page 869
 * Exercise 17: Create a radiation counter that can have any number of remote sensors.
 *
 * @author Frank Kwok on 2017/5/30.
 */
public class RadiationCounter implements Runnable {
    private List<RemoteSensor> sensors = new ArrayList<>();
    private volatile boolean canceled;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        List<RadiationCounter> counters = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            counters.add(new RadiationCounter());
        }
        for (RadiationCounter rc : counters) {
            for (int i = 0; i < 5; i++) {
                rc.addSensor(new RemoteSensor());
                pool.execute(rc);
            }
        }
        for (RadiationCounter rc : counters) {
            pool.execute(() -> {
                while (!Thread.interrupted()) {
                    System.out.println("AverageRadiation: " + rc.averageRadiation());
                }
            });
        }
        TimeUnit.SECONDS.sleep(3);
        for (RadiationCounter rc : counters) {
            rc.cancel();
        }
        pool.shutdownNow();
    }

    @Override
    public void run() {
        while (!canceled) {
            synchronized (this) {
                for (RemoteSensor rs : sensors) {
                    rs.sense();
                }
            }
        }
    }

    private void cancel() {
        canceled = true;
    }

    private synchronized void addSensor(RemoteSensor sensor) {
        sensors.add(sensor);
    }

    private synchronized int averageRadiation() {
        int result = 0;
        for (RemoteSensor rs : sensors) {
            result += rs.value();
        }
        return result / sensors.size();
    }
}

class RemoteSensor {
    private static final int BOUND = 1000;
    private int radiation;
    private Random random = new Random();

    synchronized void sense() {
        int change = random.nextInt(BOUND);
        if (random.nextBoolean()) {
            change = -change;
        }
        Thread.yield();
        radiation += change;
    }

    public synchronized int value() {
        return radiation;
    }
}
