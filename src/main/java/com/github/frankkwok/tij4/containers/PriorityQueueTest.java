package com.github.frankkwok.tij4.containers;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Page 617
 * Exercise 11: Create a class that contains an Integer that is initialized to a value between o and 100 using
 * java.util.Random. Implement Comparable using this Integer field. Fill a PriorityQueue with objects of your class,
 * and extract the values using poll( ) to show that it produces the expected order.
 *
 * @author Frank Kwok on 2017/5/19.
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<HasInteger> priorityQueue = new PriorityQueue<>();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            HasInteger hasInteger = new HasInteger(random.nextInt(100));
            priorityQueue.offer(hasInteger);
        }
        System.out.println(priorityQueue);

        while (!priorityQueue.isEmpty()) {
            System.out.print(priorityQueue.poll() + ", ");
        }
    }
}

class HasInteger implements Comparable<HasInteger> {
    private Integer integer;

    HasInteger(Integer integer) {
        this.integer = integer;
    }

    @Override
    public int compareTo(HasInteger other) {
        return integer.compareTo(other.integer);
    }

    @Override
    public String toString() {
        return "integer = " + integer;
    }
}
