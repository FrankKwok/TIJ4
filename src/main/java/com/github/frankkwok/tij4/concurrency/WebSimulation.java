package com.github.frankkwok.tij4.concurrency;

import java.util.concurrent.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Page 922
 * Exercise 35: Modify WebSimulation.java so that it represents Web clients making requests of a fixed number of
 * servers. The goal is to determine the load that the group of servers can handle.
 *
 * @author Frank Kwok on 2017/6/3.
 */
public class WebSimulation {
    private static final int MAX_LINE_SIZE = 50;
    private static final int ADJUSTMENT_PERIOD = 1000;
    private static final int NUM_OF_SERVER = 5;

    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newCachedThreadPool();
        WebClientLine webClients = new WebClientLine(MAX_LINE_SIZE);
        WebClientGenerator generator = new WebClientGenerator(webClients);
        pool.execute(new WebClientGenerator(webClients));
        pool.execute(new WebManager(pool, generator, webClients, ADJUSTMENT_PERIOD, NUM_OF_SERVER));
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        } else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        pool.shutdownNow();
    }
}

class WebClient {
    private final int serviceTime;

    WebClient(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    int getServiceTime() {
        return serviceTime;
    }

    @Override
    public String toString() {
        return "[" + serviceTime + "]";
    }
}

class WebClientLine extends ArrayBlockingQueue<WebClient> {
    WebClientLine(int maxLineSize) {
        super(maxLineSize);
    }

    @Override
    public String toString() {
        if (this.size() == 0) {
            return "[Empty]";
        }
        StringBuilder result = new StringBuilder();
        for (WebClient webClient : this) {
            result.append(webClient);
        }
        return result.toString();
    }
}

class WebClientGenerator implements Runnable {
    private static Random rand = new Random();

    private WebClientLine webClients;
    AtomicInteger loadFactor = new AtomicInteger(1);

    WebClientGenerator(WebClientLine webClients) {
        this.webClients = webClients;
    }


    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(rand.nextInt(300));
                webClients.put(new WebClient(rand.nextInt(1000 / loadFactor.get())));
            }
        } catch (InterruptedException e) {
            System.out.println("WebClientGenerator interrupted");
        }
        System.out.println("WebClientGenerator terminating");
    }
}

class Server implements Runnable {
    private static int counter = 0;

    private final int id = counter++;
    private WebClientLine webClients;

    Server(WebClientLine webClients) {
        this.webClients = webClients;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                WebClient webClient = webClients.take();
                TimeUnit.MILLISECONDS.sleep(webClient.getServiceTime());
            }
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        }
        System.out.println(this + "terminating");
    }

    @Override
    public String toString() {
        return "Server " + id + " ";
    }

    String shortString() {
        return "T" + id;
    }
}

class WebManager implements Runnable {
    private ExecutorService pool;
    private WebClientGenerator generator;
    private WebClientLine webClients;
    private Queue<Server> servers = new LinkedList<>();
    private int adjustmentPeriod;
    private boolean stable = true;
    private int preSize;

    WebManager(ExecutorService pool, WebClientGenerator generator, WebClientLine webClients, int adjustmentPeriod, int n) {
        this.pool = pool;
        this.generator = generator;
        this.webClients = webClients;
        this.adjustmentPeriod = adjustmentPeriod;
        for (int i = 0; i < n; i++) {
            Server server = new Server(webClients);
            this.pool.execute(server);
            servers.add(server);
        }
    }

    void adjustLoadFactor() {
        if (webClients.size() > preSize) {
            if (stable) {
                stable = false;
            } else if (!stable) {
                System.out.println("Get the load factor: " + generator.loadFactor.get());
                pool.shutdownNow();
            }
        } else {
            System.out.println("New load factor: " + generator.loadFactor.addAndGet(1));
            stable = true;
        }
        preSize = webClients.size();
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
                adjustLoadFactor();
                System.out.print(webClients + " { ");
                for (Server server : servers) {
                    System.out.print(server.shortString() + " ");
                }
                System.out.println("}");
                adjustLoadFactor();
            }
        } catch (InterruptedException e) {
            System.out.println(this + "interrupted");
        }
        System.out.println(this + "terminating");
    }

    @Override
    public String toString() {
        return "WebManager ";
    }
}