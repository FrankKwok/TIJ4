package com.github.frankkwok.tij4.interfaces;

/**
 * Page 263
 * Exercise 18: Create a Cycle interface, with implementations Unicycle, Bicycle and Tricycle. Create factories for each
 * type of Cycle, and code that uses these factories.
 * <p>
 * 工厂方法-Factory Methods
 *
 * @author Frank Kwok on 2017/4/12.
 */
public class CycleFactoryTest {
    public static void main(String[] args) {
        rideCycle(new UnicycleFactory());
        rideCycle(new BicycleFactory());
        rideCycle(new TricycleFactory());
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
    @Override
    public void ride() {
        System.out.println("Unicycle.ride()");
    }
}

class UnicycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class Bicycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("Bicycle.ride()");
    }
}

class BicycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}

class Tricycle implements Cycle {
    @Override
    public void ride() {
        System.out.println("Tricycle.ride()");
    }
}

class TricycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}

