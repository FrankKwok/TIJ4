package com.github.frankkwok.tij4.holding;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * Page 323
 * Exercise 28: Fill a PriorityQueue (using offer( )) with Double values created using java.util.Random, then remove the
 * elements using poll( ) and display them.
 * Exercise 29: Create a simple class that inherits from Object and contains no members, and show that you cannot
 * successfully add multiple elements of that class to a PriorityQueue. This issue will be fully explained in the
 * Containers in Depth chapter.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        Random random = new Random();
        PriorityQueue<Double> doubles = new PriorityQueue<>();
        for (int i = 0; i < 10; i++) {
            doubles.offer(random.nextDouble());
        }
        while (!doubles.isEmpty()) {
            System.out.println(doubles.poll());
        }

        PriorityQueue<Simple> simples = new PriorityQueue<>();
        simples.offer(new Simple());
        simples.offer(new Simple());
        System.out.println(simples);
    }
}

class Simple extends Object {

}
