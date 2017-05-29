package com.github.frankkwok.tij4.concurrency;

import java.util.Arrays;
import java.util.concurrent.*;

/**
 * Page 858
 * Exercise 13: Repair SerialNumberChecker.java using the synchronized keyword. Can you demonstrate that it is now
 * correct?
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class SerialNumberChecker {
    private static final int SIZE = 10;
    private static CircularSet serials = new CircularSet(1000);
    private static ExecutorService exec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {
        public void run() {
            while (true) {
                int serial = SerialNumberGenerator.nextSerialNumber();
                if (serials.contains(serial)) {
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                serials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < SIZE; i++)
            exec.execute(new SerialChecker());
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicates detected");
            System.exit(0);
        }
    }
}

class CircularSet {
    private int[] array;
    private int len;
    private int index = 0;

    CircularSet(int size) {
        array = new int[size];
        len = size;
        Arrays.fill(array, -1);
    }

    public synchronized void add(int i) {
        array[index] = i;
        index = ++index % len;
    }

    public synchronized boolean contains(int val) {
        for (int i = 0; i < len; i++) {
            if (array[i] == val) {
                return true;
            }
        }
        return false;
    }
}
