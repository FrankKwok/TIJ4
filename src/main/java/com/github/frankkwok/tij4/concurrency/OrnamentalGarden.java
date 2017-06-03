package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.*;
import java.util.*;

/**
 * Page 874
 * Exercise 19: Modify OrnamentalGarden.java so that it uses interrupt( ).
 * <p>
 * Page 902
 * Exercise 32: Use a CountDownLatch to solve the problem of correlating the results from the Entrances in
 * OrnamentalGarden.java. Remove the unnecessary code from the new version of the example.
 *
 * @author Frank Kwok on 2017/5/30.
 */
public class OrnamentalGarden {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i, countDownLatch));
        }
        TimeUnit.SECONDS.sleep(2);
        exec.shutdownNow();
        TimeUnit.SECONDS.sleep(2);
        Entrance.cancel();
        countDownLatch.await();
        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
    }
}

class Count {
    private int count = 0;
    private Random rand = new Random();

    synchronized int increment() {
        int temp = count;
        if (rand.nextBoolean()) {
            Thread.yield();
        }
        return (count = ++temp);
    }

    public synchronized int value() {
        return count;
    }
}

class Entrance implements Runnable {
    private static Count count = new Count();
    private static List<Entrance> entrances = new ArrayList<>();
    private int number = 0;
    private final int id;
    private CountDownLatch countDownLatch;
    private static volatile boolean canceled = false;

    static void cancel() {
        canceled = true;
    }

    Entrance(int id, CountDownLatch countDownLatch) {
        this.id = id;
        this.countDownLatch = countDownLatch;
        entrances.add(this);
    }

    public void run() {
        while (!canceled) {
            synchronized (this) {
                ++number;
            }
            System.out.println(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        countDownLatch.countDown();
        System.out.println("Stopping " + this);
    }

    public synchronized int getValue() {
        return number;
    }

    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    static int getTotalCount() {
        return count.value();
    }

    static int sumEntrances() {
        int sum = 0;
        for (Entrance entrance : entrances)
            sum += entrance.getValue();
        return sum;
    }
}