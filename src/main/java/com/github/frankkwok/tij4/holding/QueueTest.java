package com.github.frankkwok.tij4.holding;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Page 321
 * Exercise 27: Write a class called Command that contains a String and has a method operation( ) that displays the
 * String. Write a second class with a method that fills a Queue with Command objects and returns it. Pass the filled
 * Queue to a method in a third class that consumes the objects in the Queue and calls their operation( ) methods
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class QueueTest {
    public static void main(String[] args) {
        consume(CommandSupplier.supply());
    }

    static void consume(Queue<Command> commands) {
        while (commands.peek() != null) {
            commands.remove().operation();
        }
    }
}

class Command {
    private String word;

    public Command(String word) {
        this.word = word;
    }

    public void operation() {
        System.out.println(word);
    }
}

class CommandSupplier {
    static Queue<Command> supply() {
        Queue<Command> queue = new LinkedList<>();
        queue.offer(new Command("Hello"));
        queue.offer(new Command("Frank"));
        queue.offer(new Command("Kwok"));
        return queue;
    }
}
