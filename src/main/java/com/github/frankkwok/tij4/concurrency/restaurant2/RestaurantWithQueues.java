package com.github.frankkwok.tij4.concurrency.restaurant2;

import com.github.frankkwok.tij4.enumerated.Course;
import com.github.frankkwok.tij4.enumerated.Food;

import java.util.concurrent.*;
import java.util.*;

/**
 * Page 925
 * Exercise 36: Modify RestaurantWithQueues.java so there’s one OrderTicket object per table. Change order to
 * orderTicket, and add a Table class, with multiple Customers per table.
 *
 * @author Frank Kwok on 2017/6/3.
 */
public class RestaurantWithQueues {
    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        Restaurant restaurant = new Restaurant(exec, 5, 2);
        exec.execute(restaurant);
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
        } else {
            System.out.println("Press 'Enter' to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}

class Order {
    private static int counter = 0;
    private final int id = counter++;
    private final Customer customer;
    private final Food food;
    private OrderTicket orderTicket;

    Order(Customer customer, Food food) {
        this.customer = customer;
        this.food = food;
    }

    Food item() {
        return food;
    }

    Customer getCustomer() {
        return customer;
    }

    void setOrderTicket(OrderTicket orderTicket) {
        this.orderTicket = orderTicket;
    }

    OrderTicket getOrderTicket() {
        return orderTicket;
    }

    @Override
    public String toString() {
        return "Order: " + id + " item: " + food + " for: " + customer;
    }
}

class Plate {
    private final Order order;
    private final Food food;

    Plate(Order order, Food food) {
        this.order = order;
        this.food = food;
    }

    Order getOrder() {
        return order;
    }

    Food getFood() {
        return food;
    }

    @Override
    public String toString() {
        return food.toString();
    }
}

class Customer implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final Table table;
    private final CyclicBarrier barrier;
    private int nPlates;
    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();

    Customer(Table table, CyclicBarrier barrier) {
        this.table = table;
        this.barrier = barrier;
    }

    void deliver(Plate p) throws InterruptedException {
        placeSetting.put(p);
    }

    @Override
    public void run() {
        for (Course course : Course.values()) {
            Food food = course.randomSelection();
            table.placeOrder(this, food);
            ++nPlates;
        }
        try {
            barrier.await();
        } catch (InterruptedException e) {
            System.out.println(this + " Interrupted");
            return;
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < nPlates; i++) {
            try {
                System.out.println(this + " eating " + placeSetting.take());
            } catch (InterruptedException e) {
                System.out.println(this + " waiting for meal interrupted");
                return;
            }
        }
        System.out.println(this + "finished meal, leaving");
    }

    @Override
    public String toString() {
        return "Customer " + id + " ";
    }
}

class WaitPerson implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;
    BlockingQueue<Plate> filledOrders = new LinkedBlockingQueue<>();

    WaitPerson(Restaurant rest) {
        restaurant = rest;
    }

    void placeOrderTicket(OrderTicket orderTicket) {
        try {
            restaurant.orderTickets.put(orderTicket);
        } catch (InterruptedException e) {
            System.out.println(this + " placeOrder interrupted");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Plate plate = filledOrders.take();
                System.out.println(this + "received " + plate + " delivering to " + plate.getOrder().getCustomer());
                plate.getOrder().getCustomer().deliver(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " off duty");
    }

    @Override
    public String toString() {
        return "WaitPerson " + id + " ";
    }
}

class Chef implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final Restaurant restaurant;
    private static Random rand = new Random(47);

    Chef(Restaurant rest) {
        restaurant = rest;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                OrderTicket orderTicket = restaurant.orderTickets.take();
                final List<Order> orders = orderTicket.getOrders();
                synchronized (orders) {
                    for (Order order : orders) {
                        Food requestedItem = order.item();
                        TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                        Plate plate = new Plate(order, requestedItem);
                        order.getOrderTicket().getWaitPerson().filledOrders.put(plate);
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }
        System.out.println(this + " off duty");
    }

    @Override
    public String toString() {
        return "Chef " + id + " ";
    }
}

class Restaurant implements Runnable {
    private static Random rand = new Random();

    private List<WaitPerson> waitPersons = new ArrayList<>();
    private List<Chef> chefs = new ArrayList<>();
    private ExecutorService exec;
    BlockingQueue<OrderTicket> orderTickets = new LinkedBlockingQueue<>();

    Restaurant(ExecutorService e, int nWaitPersons, int nChefs) {
        exec = e;
        for (int i = 0; i < nWaitPersons; i++) {
            WaitPerson waitPerson = new WaitPerson(this);
            waitPersons.add(waitPerson);
            exec.execute(waitPerson);
        }
        for (int i = 0; i < nChefs; i++) {
            Chef chef = new Chef(this);
            chefs.add(chef);
            exec.execute(chef);
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                WaitPerson wp = waitPersons.get(rand.nextInt(waitPersons.size()));
                int nCustomers = rand.nextInt(4) + 1;
                Table table = new Table(wp, nCustomers, exec);
                exec.execute(table);
                TimeUnit.MILLISECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Restaurant interrupted");
        }
        System.out.println("Restaurant closing");
    }
}

class OrderTicket {
    private static int counter;

    private final int id = counter++;
    private final Table table;
    private final List<Order> orders = Collections.synchronizedList(new ArrayList<>());

    OrderTicket(Table table) {
        this.table = table;
    }

    WaitPerson getWaitPerson() {
        return table.getWaitPerson();
    }

    List<Order> getOrders() {
        return orders;
    }

    void placeOrder(Customer customer, Food food) {
        Order order = new Order(customer, food);
        order.setOrderTicket(this);
        orders.add(order);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order Ticket: ");
        sb.append(id);
        sb.append(" for: ");
        sb.append(table);
        sb.append("\n");
        synchronized (orders) {
            for (Order order : orders) {
                sb.append(order.toString());
                sb.append("\n");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }
}

class Table implements Runnable {
    private static int counter;
    private final int id = counter++;
    private final WaitPerson waitPerson;
    private final List<Customer> customers;
    private final OrderTicket orderTicket = new OrderTicket(this);
    private final CyclicBarrier cyclicBarrier;
    private final int nCustomers;
    private final ExecutorService pool;

    Table(WaitPerson waitPerson, int nCustomers, ExecutorService pool) {
        this.waitPerson = waitPerson;
        this.nCustomers = nCustomers;
        customers = Collections.synchronizedList(new LinkedList<>());
        this.pool = pool;
        cyclicBarrier = new CyclicBarrier(nCustomers + 1, () -> System.out.println(orderTicket));
    }

    WaitPerson getWaitPerson() {
        return waitPerson;
    }

    void placeOrder(Customer customer, Food food) {
        orderTicket.placeOrder(customer, food);
    }

    @Override
    public void run() {
        Customer customer;
        for (int i = 0; i < nCustomers; i++) {
            customers.add(customer = new Customer(this, cyclicBarrier));
            pool.execute(customer);
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            System.out.println(this + " Interrupted");
            return;
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        waitPerson.placeOrderTicket(orderTicket);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Table: ");
        sb.append(id);
        sb.append(" served by: ");
        sb.append(waitPerson);
        sb.append("\n");
        synchronized (customers) {
            for (Customer customer : customers) {
                sb.append(customer);
                sb.append("\n");
            }
        }
        return sb.substring(0, sb.length() - 1);
    }
}