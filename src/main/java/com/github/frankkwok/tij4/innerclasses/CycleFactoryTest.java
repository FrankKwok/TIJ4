package com.github.frankkwok.tij4.innerclasses;

/**
 * Page 278
 * Exercise 16: Modify the solution to Exercise 18 from the Interfaces chapter to use anonymous inner classes.
 *
 * @author Frank Kwok on 2017/4/13.
 */
public class CycleFactoryTest {
    public static void main(String[] args) {
        rideCycle(Unicycle.cycleFactory);
        rideCycle(Bicycle.cycleFactory);
        rideCycle(Tricycle.cycleFactory);
    }

    private static void rideCycle(CycleFactory cycleFactory) {
        cycleFactory.getCycle().ride();
    }
}

interface Cycle {
    void ride();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {
    public static CycleFactory cycleFactory = Unicycle::new;

    @Override
    public void ride() {
        System.out.println("Unicycle.ride()");
    }
}

class Bicycle implements Cycle {
    public static CycleFactory cycleFactory = Bicycle::new;

    @Override
    public void ride() {
        System.out.println("Bicycle.ride()");
    }
}

class Tricycle implements Cycle {
    public static CycleFactory cycleFactory = Tricycle::new;

    @Override
    public void ride() {
        System.out.println("Tricycle.ride()");
    }
}
