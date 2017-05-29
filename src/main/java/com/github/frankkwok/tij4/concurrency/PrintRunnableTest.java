package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Page 826
 * Exercise 1: Implement a Runnable. Inside run( ), print a message, and then call yield( ). Repeat this three times,
 * and then return from run( ). Put a startup message in the constructor and a shutdown message when the task terminates.
 * Create a number of these tasks and drive them using threads.
 * <p>
 * Page 828
 * Exercise 3: Repeat Exercise 1 using the different types of executors shown in this section.
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class PrintRunnableTest {
    public static void main(String[] args) {
        // Exercise 1
        for (int i = 0; i < 5; i++) {
            new Thread(new PrintTask(i)).start();
        }

        // CachedThreadPool
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            pool.execute(new PrintTask(i));
        }
        pool.shutdown();

        // FixedThreadPool
        pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            pool.execute(new PrintTask(i));
        }
        pool.shutdown();

        // SingleThreadExecutor
        pool = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            pool.execute(new PrintTask(i));
        }
        pool.shutdown();
    }
}

class PrintTask implements Runnable {
    private final int id;

    PrintTask(int id) {
        this.id = id;
        System.out.printf("#%d Start print%n", id);
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.printf("#%d hello, world%n", id);
            Thread.yield();
        }
        System.out.printf("#%d Finish print%n", id);
    }
}
