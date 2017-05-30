package com.github.frankkwok.tij4.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Page 874
 * Exercise 20: Modify CachedThreadPool.java so that all tasks receive an interrupt( ) before they are completed.
 *
 * @author Frank Kwok on 2017/5/30.
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futures.add(exec.submit(new LiftOff()));
        }
        for (Future<?> f : futures) {
            f.cancel(true);
        }
        exec.shutdownNow();
    }
}
