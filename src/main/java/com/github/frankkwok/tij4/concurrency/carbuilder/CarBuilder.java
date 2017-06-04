package com.github.frankkwok.tij4.concurrency.carbuilder;

import java.util.concurrent.*;
import java.util.*;

/**
 * Page 930
 * Exercise 37: Modify CarBuilder.java to add another stage to the car-building process, whereby you add the exhaust
 * system, body, and fenders. As with the second stage, assume these processes can be performed simultaneously by robots.
 *
 * @author Frank Kwok on 2017/6/4
 */
public class CarBuilder {
    public static void main(String[] args) throws Exception {
        CarQueue chassisQueue = new CarQueue(), finishingQueue = new CarQueue();
        ExecutorService pool = Executors.newCachedThreadPool();
        RobotPool robotPool = new RobotPool();
        pool.execute(new EngineRobot(robotPool));
        pool.execute(new DriveTrainRobot(robotPool));
        pool.execute(new WheelRobot(robotPool));
        pool.execute(new ExhaustSystemRobot(robotPool));
        pool.execute(new BodyRobot(robotPool));
        pool.execute(new FendersRobot(robotPool));
        pool.execute(new Assembler(chassisQueue, finishingQueue, robotPool));
        pool.execute(new Reporter(finishingQueue));
        pool.execute(new ChassisBuilder(chassisQueue));
        TimeUnit.SECONDS.sleep(7);
        pool.shutdownNow();
    }
}

class Car {
    private final int id;
    private boolean engine = false, driveTrain = false, wheels = false,
            exhaustSystem = false, body = false, fenders = false;

    Car(int id) {
        this.id = id;
    }

    synchronized int getId() {
        return id;
    }

    synchronized void addEngine() {
        engine = true;
    }

    synchronized void addDriveTrain() {
        driveTrain = true;
    }

    synchronized void addWheels() {
        wheels = true;
    }

    void addExhaustSystem() {
        exhaustSystem = true;
    }

    void addBody() {
        body = true;
    }

    void addFenders() {
        fenders = true;
    }

    @Override
    public synchronized String toString() {
        return "Car " + id + " [" + " engine: " + engine +
                " driveTrain: " + driveTrain +
                " wheels: " + wheels +
                " exhaustSystem: " + exhaustSystem +
                " body: " + body +
                " fenders: " + fenders + " ]";
    }
}

class CarQueue extends LinkedBlockingQueue<Car> {
}

class ChassisBuilder implements Runnable {
    private CarQueue carQueue;
    private int counter = 0;

    ChassisBuilder(CarQueue carQueue) {
        this.carQueue = carQueue;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(500);
                Car c = new Car(counter++);
                System.out.println("ChassisBuilder created " + c);
                carQueue.put(c);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted: ChassisBuilder");
        }
        System.out.println("ChassisBuilder off");
    }
}

class Assembler implements Runnable {
    private CarQueue chassisQueue, finishingQueue;
    private Car car;
    private CyclicBarrier barrier = new CyclicBarrier(4);
    private RobotPool robotPool;

    Assembler(CarQueue cq, CarQueue fq, RobotPool rp) {
        chassisQueue = cq;
        finishingQueue = fq;
        robotPool = rp;
    }

    Car car() {
        return car;
    }

    CyclicBarrier barrier() {
        return barrier;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                car = chassisQueue.take();
                robotPool.hire(EngineRobot.class, this);
                robotPool.hire(DriveTrainRobot.class, this);
                robotPool.hire(WheelRobot.class, this);
                barrier.await();
                robotPool.hire(ExhaustSystemRobot.class, this);
                robotPool.hire(BodyRobot.class, this);
                robotPool.hire(FendersRobot.class, this);
                barrier.await();
                finishingQueue.put(car);
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Assembler via interrupt");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Assembler off");
    }
}

class Reporter implements Runnable {
    private CarQueue carQueue;

    Reporter(CarQueue cq) {
        carQueue = cq;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(carQueue.take());
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Reporter via interrupt");
        }
        System.out.println("Reporter off");
    }
}

abstract class Robot implements Runnable {
    private RobotPool pool;
    private boolean engage = false;
    protected Assembler assembler;

    Robot(RobotPool p) {
        pool = p;
    }


    Robot assignAssembler(Assembler assembler) {
        this.assembler = assembler;
        return this;
    }

    synchronized void engage() {
        engage = true;
        notifyAll();
    }

    abstract protected void performService();

    @Override
    public void run() {
        try {
            powerDown();
            while (!Thread.interrupted()) {
                performService();
                assembler.barrier().await();
                powerDown();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting " + this + " via interrupt");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this + " off");
    }

    private synchronized void powerDown() throws InterruptedException {
        engage = false;
        assembler = null;
        pool.release(this);
        while (!engage) {
            wait();
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class EngineRobot extends Robot {
    EngineRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing engine");
        assembler.car().addEngine();
    }
}

class DriveTrainRobot extends Robot {
    DriveTrainRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing DriveTrain");
        assembler.car().addDriveTrain();
    }
}

class WheelRobot extends Robot {
    WheelRobot(RobotPool pool) {
        super(pool);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing Wheels");
        assembler.car().addWheels();
    }
}

class ExhaustSystemRobot extends Robot {
    ExhaustSystemRobot(RobotPool p) {
        super(p);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing ExhaustSystem");
        assembler.car().addExhaustSystem();
    }
}

class BodyRobot extends Robot {
    BodyRobot(RobotPool p) {
        super(p);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing Body");
        assembler.car().addBody();
    }
}

class FendersRobot extends Robot {
    FendersRobot(RobotPool p) {
        super(p);
    }

    @Override
    protected void performService() {
        System.out.println(this + " installing Fenders");
        assembler.car().addFenders();
    }
}

class RobotPool {
    private Set<Robot> pool = new HashSet<>();

    synchronized void hire(Class<? extends Robot> robotType, Assembler d)
            throws InterruptedException {
        for (Robot r : pool)
            if (r.getClass().equals(robotType)) {
                pool.remove(r);
                r.assignAssembler(d)
                        .engage();
                return;
            }
        wait();
        hire(robotType, d);
    }

    synchronized void release(Robot r) {
        pool.add(r);
        notifyAll();
    }
}
