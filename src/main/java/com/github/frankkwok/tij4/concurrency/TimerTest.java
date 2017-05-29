package com.github.frankkwok.tij4.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Page 859
 * Exercise 14: Demonstrate that java.util.Timer scales to large numbers by creating a program that generates many Timer
 * objects that perform some simple task when the timeout completes.
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class TimerTest {
    private static AtomicInteger ai = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Timer timer = new Timer("Timer #" + i);
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    System.out.println(ai.addAndGet(2));
                }
            }, 1000, 1000);
        }
    }
}
