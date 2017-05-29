package com.github.frankkwok.tij4.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Page 829
 * Exercise 5: Modify Exercise 2 so that the task is a Callable that sums the values of all the Fibonacci numbers.
 * Create several tasks and display the results.
 * <p>
 * Page 841
 * Exercise 10: Modify Exercise 5 following the example of the ThreadMethod class, so that runTask( ) takes an argument
 * of the number of Fibonacci numbers to sum, and each time you call runTask( ) it returns the Future produced by the
 * call to submit( ).
 *
 * @author Frank Kwok on 2017/5/29.
 */
public class FibonacciCallableTest {
    public static void main(String[] args) {
        ThreadMethod tm = new ThreadMethod();
        List<Future<Integer>> futures = new ArrayList<>();
        for (int i = 15; i < 20; i++) {
            futures.add(tm.runTask(i));
        }

        for (Future<Integer> f : futures) {
            try {
                System.out.println(f.get() + " ");
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                tm.shutdown();
            }
        }
    }
}

class FibonacciCallable implements Callable<Integer> {
    private final int count;

    FibonacciCallable(int count) {
        this.count = count;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 0; i < count; i++) {
            result += fib(i);
        }
        return result;
    }

    private int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}

class ThreadMethod {
    private ExecutorService pool = Executors.newCachedThreadPool();

    Future<Integer> runTask(int count) {
        return pool.submit(new FibonacciCallable(count));
    }

    void shutdown() {
        pool.shutdown();
    }
}
