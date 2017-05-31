package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Page 888
 * Exercise 24: Solve a single-producer, single-consumer problem using wait( ) and notifyAll( ). The producer must not
 * overflow the receiver’s buffer, which can happen if the producer is faster than the consumer. If the consumer is
 * faster than the producer, then it must not read the same data more than once. Do not assume anything about the
 * relative speeds of the producer or consumer
 *
 * @author Frank Kwok on 2017/5/31.
 */
public class SingleProducerConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService pool = Executors.newCachedThreadPool();
        SingConsumer consumer = new SingConsumer();
        SingleProducer producer = new SingleProducer(consumer);
        pool.execute(consumer);
        pool.execute(consumer);
        TimeUnit.SECONDS.sleep(3);
        pool.shutdownNow();
    }
}

class SingleProducer implements Runnable {
    private final SingConsumer consumer;

    SingleProducer(SingConsumer consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (consumer) {
                    while (!consumer.isFull()) {
                        consumer.put();
                    }
                    notifyAll();
                    while (consumer.isFull()) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SingConsumer implements Runnable {
    private int buffer;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (!isEmpty()) {
                        get();
                    }
                    notifyAll();
                    while (isFull()) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    boolean isFull() {
        return buffer >= 256;
    }

    boolean isEmpty() {
        return buffer <= 0;
    }

    void put() {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Overflow");
        }
        buffer++;
    }

    void get() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("There is nothing");
        }
        buffer--;
    }
}