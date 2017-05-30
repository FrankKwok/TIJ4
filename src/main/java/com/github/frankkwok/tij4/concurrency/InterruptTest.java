package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * Page 874
 * Exercise 18: Create a non-task class with a method that calls sleep( ) for a long interval. Create a task that calls
 * the method in the non-task class. In main( ), start the task, then call interrupt( ) to terminate it. Make sure that
 * the task shuts down safely.
 *
 * @author Frank Kwok on 2017/5/30.
 */
public class InterruptTest {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptTask(new WithSleep()));
        thread.start();
        TimeUnit.MILLISECONDS.sleep(100);
        thread.interrupt();
        System.out.println("Exiting main");
    }
}

class InterruptTask implements Runnable {
    private WithSleep withSleep;

    InterruptTask(WithSleep withSleep) {
        this.withSleep = withSleep;
    }

    @Override
    public void run() {
        withSleep.withSleep();
        System.out.println("Exiting safely");
    }
}

class WithSleep {
    void withSleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
