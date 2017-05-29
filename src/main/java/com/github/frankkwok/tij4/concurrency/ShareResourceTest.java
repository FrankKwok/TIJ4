package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Page 851
 * Exercise 11: Create a class containing two data fields, and a method that manipulates those fields in a multistep
 * process so that, during the execution of that method, those fields are in an "improper state" (according to some
 * definition that you establish). Add methods to read the fields, and create multiple threads to call the various
 * methods and show that the data is visible in its "improper state." Fix the problem using the synchronized keyword.
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class ShareResourceTest {
    public static void main(String[] args) {
        ShareResource sr = new ShareResource();
        ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            pool.execute(() -> {
                while (true) {
                    sr.change();
                }
            });
            pool.execute(() -> {
                while (true) {
                    System.out.println(sr.getEven());
                    System.out.println(sr.getHalf());
                }
            });
        }
        pool.shutdown();
    }
}

class ShareResource {
    private int even = 0;
    private double half = 0.5;

    synchronized int getEven() {
        return even;
    }

    synchronized double getHalf() {
        return half;
    }

    synchronized void change() {
        ++even;
        ++even;
        half += 0.25;
        half += 0.25;
        half += 0.25;
        half += 0.25;
    }
}
