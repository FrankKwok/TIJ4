package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Page 865
 * Exercise 15: Create a class with three methods containing critical sections that all synchronize on the same object.
 * Create multiple tasks to demonstrate that only one of these methods can run at a time. Now modify the methods so that
 * each one synchronizes on a different object and show that all three methods can be running at once.
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class SyncTest {
    public static void main(String[] args) {
        Sync sync = new Sync();
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(sync::f);
        pool.execute(sync::g);
        pool.execute(sync::h);
        pool.shutdown();
    }
}

class Sync {
    private final Object syncF = new Object();
    private final Object syncG = new Object();
    private final Object syncH = new Object();

    void f() {
        synchronized (syncF) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Sync.f()");
                Thread.yield();
            }
        }
    }

    void g() {
        synchronized (syncG) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Sync.g()");
                Thread.yield();
            }
        }
    }

    void h() {
        synchronized (syncH) {
            for (int i = 0; i < 10; i++) {
                System.out.println("Sync.h()");
                Thread.yield();
            }
        }
    }
}
