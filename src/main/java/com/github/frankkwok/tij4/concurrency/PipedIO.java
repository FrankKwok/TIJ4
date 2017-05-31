package com.github.frankkwok.tij4.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Page 896
 * Exercise 30: Modify PipedIO.java to use a BlockingQueue instead of a pipe.
 *
 * @author Frank Kwok on 2017/5/31.
 */
public class PipedIO {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        CharQueue charQueue = new CharQueue();
        Sender sender = new Sender(charQueue);
        Receiver receiver = new Receiver(charQueue);
        pool.execute(sender);
        pool.execute(receiver);
        TimeUnit.SECONDS.sleep(5);
        pool.shutdownNow();
    }
}

class Sender implements Runnable {
    private Random rand = new Random();
    private CharQueue charQueue;

    Sender(CharQueue charQueue) {
        this.charQueue = charQueue;
    }

    public void run() {
        try {
            while (true)
                for (char c = 'A'; c <= 'z'; c++) {
                    charQueue.put(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
        } catch (InterruptedException e) {
            System.out.println(e + " Sender sleep interrupted");
        }
    }
}

class Receiver implements Runnable {
    private CharQueue charQueue;

    Receiver(CharQueue charQueue) {
        this.charQueue = charQueue;
    }

    public void run() {
        try {
            while (true) {
                System.out.print("Read: " + charQueue.take() + ", ");
            }
        } catch (InterruptedException e) {
            System.out.println(e + " Receiver sleep interrupted");
        }
    }
}

class CharQueue extends LinkedBlockingQueue<Character> {

}
