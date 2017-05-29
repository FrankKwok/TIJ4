package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Page 831
 * Exercise 6: Create a task that sleeps for a random amount of time between 1 and 10 seconds, then displays its sleep
 * time and exits. Create and run a quantity (given on the command line) of these tasks.
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class SleepRunnableTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            pool.execute(new SleepRunnable());
        }
        pool.shutdown();
    }
}

class SleepRunnable implements Runnable {
    private static final int LOW_BOUND = 1000;
    private static final int HIGH_BOUND = 10000;

    @Override
    public void run() {
        System.out.println("Start run and sleep");
        int millis = (int) (Math.random() * (HIGH_BOUND - LOW_BOUND)) + LOW_BOUND;
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.printf("Sleep %d millis%n", millis);
        }
    }
}
