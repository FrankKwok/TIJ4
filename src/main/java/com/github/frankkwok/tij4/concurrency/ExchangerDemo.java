package com.github.frankkwok.tij4.concurrency;

import com.github.frankkwok.tij4.generics.coffee.Coffee;
import com.github.frankkwok.tij4.util.Generator;

import java.util.List;
import java.util.concurrent.*;

/**
 * Page 917
 * Exercise 34: Modify ExchangerDemo.java to use your own class instead of Fat.
 *
 * @author Frank Kwok on 2017/6/3.
 */
public class ExchangerDemo {
    static int size = 10;
    private static int delay = 5;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Exchanger<List<Coffee>> exchanger = new Exchanger<>();
        List<Coffee>
                producerList = new CopyOnWriteArrayList<>(),
                consumerList = new CopyOnWriteArrayList<>();
        exec.execute(new ExchangerProducer<>(Coffee::new, exchanger, producerList));
        exec.execute(new ExchangerConsumer<>(exchanger, consumerList));
        TimeUnit.SECONDS.sleep(delay);
        exec.shutdownNow();
    }
}

class ExchangerProducer<T> implements Runnable {
    private Generator<T> generator;
    private Exchanger<List<T>> exchanger;
    private List<T> holder;

    ExchangerProducer(Generator<T> generator, Exchanger<List<T>> exchanger, List<T> holder) {
        this.generator = generator;
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                for (int i = 0; i < ExchangerDemo.size; i++) {
                    holder.add(generator.next());
                }
                holder = exchanger.exchange(holder);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ExchangerConsumer<T> implements Runnable {
    private Exchanger<List<T>> exchanger;
    private List<T> holder;
    private volatile T value;

    ExchangerConsumer(Exchanger<List<T>> exchanger, List<T> holder) {
        this.exchanger = exchanger;
        this.holder = holder;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                holder = exchanger.exchange(holder);
                for (T t : holder) {
                    value = t;
                    holder.remove(t);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final value: " + value);
    }
}
