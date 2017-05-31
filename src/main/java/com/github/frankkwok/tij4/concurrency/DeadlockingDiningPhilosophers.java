package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.*;

/**
 * Page 900
 * Exercise 31: Change DeadlockingDiningPhilosophers.java so that when a philosopher is done with its chopsticks, it
 * drops them into a bin. When a philosopher wants to eat, it takes the next two available chopsticks from the bin. Does
 * this eliminate the possibility of deadlock? Can you reintroduce deadlock by simply reducing the number of available
 * chopsticks?
 * <p>
 *
 * @author Frank Kwok on 2017/5/31.
 */

public class DeadlockingDiningPhilosophers {
    public static void main(String[] args) throws Exception {
        ChopstickBin bin = new ChopstickBin();
        int ponder = 5;
        if (args.length > 0) {
            ponder = Integer.parseInt(args[0]);
        }
        int size = 5;
        if (args.length > 1) {
            size = Integer.parseInt(args[1]);
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < size; i++) {
            exec.execute(new Philosopher(bin,  i, ponder));
        }
        if (args.length == 3 && args[2].equals("timeout")) {
            TimeUnit.SECONDS.sleep(5);
        } else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}
