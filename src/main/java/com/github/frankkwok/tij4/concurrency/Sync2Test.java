package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Page 865
 * Exercise 16: Modify Exercise 15 to use explicit Lock objects.
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class Sync2Test {
    public static void main(String[] args) {
        Sync2 sync2 = new Sync2();
        ExecutorService pool = Executors.newCachedThreadPool();
        pool.execute(sync2::f);
        pool.execute(sync2::g);
        pool.execute(sync2::h);
        pool.shutdown();
    }
}

class Sync2 {
    private final Lock lockF = new ReentrantLock();
    private final Lock lockG = new ReentrantLock();
    private final Lock lockH = new ReentrantLock();

    void f() {
        lockF.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Sync.f()");
                Thread.yield();
            }
        } finally {
            lockF.unlock();
        }
    }

    void g() {
        lockG.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Sync.g()");
                Thread.yield();
            }
        } finally {
            lockG.unlock();
        }
    }

    void h() {
        lockH.lock();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Sync.h()");
                Thread.yield();
            }
        } finally {
            lockH.unlock();
        }
    }
}
