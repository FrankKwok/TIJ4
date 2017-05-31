package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Page 882
 * Exercise 21: Create two Runnables, one with a run( ) that starts and calls wait( ). The second class should capture
 * the reference of the first Runnable object. Its run( ) should call notifyAll( ) for the first task after some number
 * of seconds have passed so that the first task can display a message. Test your classes using an Executor.
 *
 * @author Frank Kwok on 2017/5/30.
 */
public class WaitNotifyTest {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        WaitRunnable wr = new WaitRunnable();
        NotifyAllRunnable nar = new NotifyAllRunnable(wr);
        pool.execute(wr);
        pool.execute(nar);
        pool.shutdown();
    }
}

class WaitRunnable implements Runnable {
    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
                System.out.println("hello, world");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class NotifyAllRunnable implements Runnable {
    private final WaitRunnable waitRunnable;

    NotifyAllRunnable(WaitRunnable waitRunnable) {
        this.waitRunnable = waitRunnable;
    }

    @Override
    public void run() {
        synchronized (waitRunnable) {
            try {
                Thread.sleep(1000);
                waitRunnable.notifyAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
