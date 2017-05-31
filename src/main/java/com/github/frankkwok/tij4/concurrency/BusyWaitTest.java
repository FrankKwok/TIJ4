package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Page 882
 * Exercise 22: Create an example of a busy wait. One task sleeps for a while and then sets a flag to true. The second
 * task watches that flag inside a while loop (this is the busy wait) and when the flag becomes true, sets it back to
 * false and reports the change to the console. Note how much wasted time the program spends inside the busy wait, and
 * create a second version of the program that uses wait( ) instead of the busy wait.
 *
 * @author Frank Kwok on 2017/5/30.
 */
public class BusyWaitTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        BusyWaitRunnable bwr = new BusyWaitRunnable();
        FlagRunnable fr = new FlagRunnable(bwr);
        pool.execute(bwr);
        pool.execute(fr);
        pool.shutdown();
    }
}

class BusyWaitRunnable implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            try {
                Thread.sleep(500);
                wait();
                System.out.println("hello, world");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class FlagRunnable implements Runnable {
    private final BusyWaitRunnable bsr;

    FlagRunnable(BusyWaitRunnable bsr) {
        this.bsr = bsr;
    }

    @Override
    public void run() {
        synchronized (bsr) {
            try {
                Thread.sleep(1000);
                bsr.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
