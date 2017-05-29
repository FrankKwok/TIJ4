package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.*;

/**
 * Page 858
 * Exercise 12: Repair AtomicityTest.java using the synchronized keyword. Can you demonstrate that it is now correct?
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class AtomicityTest implements Runnable {
    private int i = 0;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest at = new AtomicityTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }

    public synchronized int getValue() {
        return i;
    }

    private synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }
}
