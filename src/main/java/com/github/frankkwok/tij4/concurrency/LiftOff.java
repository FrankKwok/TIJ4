package com.github.frankkwok.tij4.concurrency;

/**
 * Page 836
 * Exercise 8: Modify MoreBasicThreads.java so that all the threads are daemon threads, and verify that the program ends
 * as soon as main( ) is able to exit.
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class LiftOff implements Runnable {
    private int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    /*package*/ LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }

    private String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }
}
