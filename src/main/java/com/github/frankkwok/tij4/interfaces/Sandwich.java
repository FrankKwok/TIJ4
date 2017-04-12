package com.github.frankkwok.tij4.interfaces;

/**
 * Page 247
 * Exercise 8: In polymorphism.Sandwich.java, create an interface called FastFoo d (with appropriate methods) and change
 * Sandwich so that it also implements FastFood.
 *
 * @author Frank Kwok on 2017/4/12.
 */
public class Sandwich extends PortableLunch implements FastFood {
    private Bread b = new Bread();
    private Cheese c = new Cheese();
    private Lettuce l = new Lettuce();

    private Sandwich() {
        System.out.println("Sandwich()");
    }

    public static void main(String[] args) {
        new Sandwich();
    }

    @Override
    public void cookFast() {
        System.out.println("This can be cook very fast.");
    }
}

class Meal {
    Meal() {
        System.out.println("Meal()");
    }
}

class Bread {
    Bread() {
        System.out.println("Bread()");
    }
}

class Cheese {
    Cheese() {
        System.out.println("Cheese()");
    }
}

class Lettuce {
    Lettuce() {
        System.out.println("Lettuce()");
    }
}

class Lunch extends Meal {
    Lunch() {
        System.out.println("Lunch()");
    }
}

class PortableLunch extends Lunch {
    PortableLunch() {
        System.out.println("PortableLunch()");
    }
}

interface FastFood {
    void cookFast();
}
