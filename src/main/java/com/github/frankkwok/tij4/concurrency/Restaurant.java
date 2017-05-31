package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Page 888
 * Exercise 25: In the Chef class in Restaurant.java, return from run( ) after calling shutdownNow( ) and observe the
 * difference in behavior.
 * Exercise 26: Add a BusBoy class to Restaurant.java. After the meal is delivered, the WaitPerson should notify the
 * BusBoy to clean up.
 * <p>
 * Page 890
 * Exercise 27: Modify Restaurant.java to use explicit Lock and Condition objects.
 *
 * @author Frank Kwok on 2017/5/31.
 */

public class Restaurant {
    Meal meal;
    volatile boolean needClean;
    ExecutorService exec = Executors.newCachedThreadPool();
    final WaitPerson waitPerson = new WaitPerson(this);
    final Chef chef = new Chef(this);
    final BusBoy busBoy = new BusBoy(this);

    public Restaurant() {
        exec.execute(chef);
        exec.execute(waitPerson);
        exec.execute(busBoy);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}

class Meal {
    private final int orderNum;

    Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString() {
        return "Meal " + orderNum;
    }
}

class WaitPerson implements Runnable {
    private final Restaurant restaurant;
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (restaurant.meal == null) {
                        condition.await();
                    }
                } finally {
                    lock.unlock();
                }
                System.out.println("Waitperson got " + restaurant.meal);
                restaurant.chef.lock.lock();
                try {
                    restaurant.meal = null;
                    restaurant.chef.condition.signalAll();
                    restaurant.busBoy.lock.lock();
                    try {
                        restaurant.needClean = true;
                        restaurant.busBoy.condition.signalAll();
                    } finally {
                        restaurant.busBoy.lock.unlock();
                    }
                } finally {
                    restaurant.chef.lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("WaitPerson interrupted");
        }
    }
}

class Chef implements Runnable {
    private final Restaurant restaurant;
    private int count = 0;
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (restaurant.meal != null) {
                        condition.await();
                    }
                } finally {
                    lock.unlock();
                }
                if (++count == 10) {
                    System.out.println("Out of food, closing");
                    restaurant.exec.shutdownNow();
//                    return;
                }
                System.out.println("Order up! ");
                restaurant.waitPerson.lock.lock();
                try {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.condition.signalAll();
                } finally {
                    restaurant.waitPerson.lock.unlock();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}

class BusBoy implements Runnable {
    private final Restaurant restaurant;
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    BusBoy(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                lock.lock();
                try {
                    while (!restaurant.needClean) {
                        condition.await();
                    }
                    System.out.println("Clean ");
                    restaurant.needClean = false;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}