package com.github.frankkwok.tij4.concurrency;

/**
 * Page 900
 * Exercise 31: Change DeadlockingDiningPhilosophers.java so that when a philosopher is done with its chopsticks, it
 * drops them into a bin. When a philosopher wants to eat, it takes the next two available chopsticks from the bin. Does
 * this eliminate the possibility of deadlock? Can you reintroduce deadlock by simply reducing the number of available
 * chopsticks?
 *
 * @author Frank Kwok on 2017/5/31.
 */
public class Chopstick {
    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void drop() {
        taken = false;
        notifyAll();
    }
}
