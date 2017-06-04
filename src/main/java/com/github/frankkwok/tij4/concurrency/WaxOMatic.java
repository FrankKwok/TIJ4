package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Page 885
 * Exercise 23: Demonstrate that WaxOMatic.java works successfully when you use notify( ) instead of notifyAll( ).
 * <p>
 * Page 950
 * Exercise 42: Modify WaxOMatic.java so that it implements active objects.
 *
 * @author Frank Kwok on 2017/5/30.
 */
public class WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        Car car = new Car();
        car.waxOn();
        car.waxOff();
        TimeUnit.SECONDS.sleep(5);
        car.shutdownNow();
    }
}

class Car {
    private ExecutorService exec = Executors.newCachedThreadPool();
    private boolean waxOn = false;

    private synchronized void waxed() {
        waxOn = true;
        notify();
    }

    private synchronized void buffed() {
        waxOn = false;
        notify();
    }

    private synchronized void waitForWaxing() throws InterruptedException {
        while (!waxOn) {
            wait();
        }
    }

    private synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn) {
            wait();
        }
    }

    public void waxOn() {
        exec.execute(() -> {
            try {
                while (!Thread.interrupted()) {
                    System.out.println("Wax On! ");
                    TimeUnit.MILLISECONDS.sleep(200);
                    waxed();
                    waitForBuffing();
                }
            } catch (InterruptedException e) {
                System.out.println("Exiting via interrupt");
            }
            System.out.println("Ending Wax On task");
        });
    }

    public void waxOff() {
        exec.execute(() -> {
            try {
                while (!Thread.interrupted()) {
                    waitForWaxing();
                    System.out.println("Wax Off! ");
                    TimeUnit.MILLISECONDS.sleep(200);
                    buffed();
                }
            } catch (InterruptedException e) {
                System.out.println("Exiting via interrupt");
            }
            System.out.println("Ending Wax Off task");
        });
    }

    public void shutdownNow() {
        exec.shutdownNow();
    }
}
