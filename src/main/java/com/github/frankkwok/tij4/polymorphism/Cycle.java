package com.github.frankkwok.tij4.polymorphism;

/**
 * Page 217
 * Exercise 1: Create a Cycle class, with subclasses Unicycle, Bicycle and Tricycle. Demonstrate that an instance of
 * each type can be upcast to Cycle via a ride( ) method.
 * <p>
 * Page 221
 * Exercise 5: Starting from Exercise 1, add a wheels( ) method in Cycle, which returns the number of wheels. Modify
 * ride( ) to call wheels( ) and verify that polymorphism works.
 * <p>
 * Page 238
 * Exercise 17: Using the Cycle hierarchy from Exercise 1, add a balance( ) method to Unicycle and Bicycle, but not to
 * Tricycle. Create instances of all three types and upcast them to an array of Cycle. Try to call balance( ) on each
 * element of the array and observe the results. Downcast and call balance( ) and observe what happens.
 *
 * @author Frank Kwok on 2017/4/11.
 */
public class Cycle {
    public static void main(String[] args) {
        Cycle[] cycles = new Cycle[]{
                new Cycle(), new Unicycle(),
                new Bicycle(), new Tricycle()
        };
        for (Cycle c : cycles) {
            c.ride();
            System.out.println("wheels = " + c.wheels());
            /*
             * Error:(28, 14) java: 找不到符号
             * 符号:   方法 balance()
             * (位置: 类型为com.github.frankkwok.tij4.polymorphism.Cycle的变量 c
             */
//            c.balance();
            /*
             * Exception in thread "main" java.lang.ClassCastException: com.github.frankkwok.tij4.polymorphism.Cycle cannot be cast to com.github.frankkwok.tij4.polymorphism.Unicycle
             * at com.github.frankkwok.tij4.polymorphism.Cycle.main(Cycle.java:34)
             */
            ((Unicycle) c).balance();
        }
    }

    void ride() {
        System.out.println("Cycle.ride()");
    }

    int wheels() {
        return 0;
    }
}

class Unicycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Unicycle.ride()");
    }

    @Override
    int wheels() {
        return 1;
    }

    void balance() {
        System.out.println("Unicycle.balance()");
    }
}

class Bicycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Bicycle.ride()");
    }

    @Override
    int wheels() {
        return 2;
    }

    void balance() {
        System.out.println("Bicycle.balance()");
    }
}

class Tricycle extends Cycle {
    @Override
    void ride() {
        System.out.println("Tricycle.ride()");
    }

    @Override
    int wheels() {
        return 3;
    }
}
