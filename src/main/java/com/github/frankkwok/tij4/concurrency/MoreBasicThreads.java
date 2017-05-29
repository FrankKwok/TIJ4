package com.github.frankkwok.tij4.concurrency;

/**
 * Page 836
 * Exercise 8: Modify MoreBasicThreads.java so that all the threads are daemon threads, and verify that the program ends
 * as soon as main( ) is able to exit.
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LiftOff());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
