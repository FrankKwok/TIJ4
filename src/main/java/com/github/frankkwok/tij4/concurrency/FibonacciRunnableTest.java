package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Page 826
 * Exercise 2: Following the form of generics/Fibonacci.java, create a task that produces a sequence of n Fibonacci
 * numbers, where n is provided to the constructor of the task. Create a number of these tasks and drive them using
 * threads.
 * <p>
 * Page 828
 * Exercise 4: Repeat Exercise 2 using the different types of executors shown in this section.
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class FibonacciRunnableTest {
    public static void main(String[] args) {
        // Exercise 2
        for (int i = 15; i < 20; i++) {
            new Thread(new FibonacciTask(i)).start();
        }

        // CachedThreadPool
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 20; i < 25; i++) {
            pool.execute(new FibonacciTask(i));
        }
        pool.shutdown();

        // FixedThreadPool
        pool = Executors.newFixedThreadPool(5);
        for (int i = 25; i < 30; i++) {
            pool.execute(new FibonacciTask(i));
        }
        pool.shutdown();

        // SingleThreadExecutor
        pool = Executors.newSingleThreadExecutor();
        for (int i = 35; i < 40; i++) {
            pool.execute(new FibonacciTask(i));
        }
        pool.shutdown();
    }
}

class FibonacciTask implements Runnable {
    private final int count;

    FibonacciTask(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            System.out.print(fib(i) + " ");
        }
    }

    private int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
