package com.github.frankkwok.tij4.concurrency;

import com.github.frankkwok.tij4.util.TwoTuple;

import java.util.concurrent.*;
import java.util.*;

/**
 * Page 900
 * Exercise 31: Change DeadlockingDiningPhilosophers.java so that when a philosopher is done with its chopsticks, it
 * drops them into a bin. When a philosopher wants to eat, it takes the next two available chopsticks from the bin. Does
 * this eliminate the possibility of deadlock? Can you reintroduce deadlock by simply reducing the number of available
 * chopsticks?
 *
 * @author Frank Kwok on 2017/5/31.
 */
public class Philosopher implements Runnable {
    private ChopstickBin bin;
    private Chopstick left;
    private Chopstick right;
    private final int id;
    private final int ponderFactor;
    private Random rand = new Random();

    private void pause() throws InterruptedException {
        if (ponderFactor == 0) {
            return;
        }
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
    }

    public Philosopher(ChopstickBin bin, int ident, int ponder) {
        this.bin = bin;
        id = ident;
        ponderFactor = ponder;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " thinking");
                pause();
                System.out.println(this + " get two chopsticks");
                TwoTuple<Chopstick, Chopstick> pair = bin.get();
                left = pair.first;
                right = pair.second;
                System.out.println(this + " eating");
                pause();
                bin.add(left, right);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " exiting via interrupt");
        }
    }

    public String toString() {
        return "Philosopher " + id;
    }
}
