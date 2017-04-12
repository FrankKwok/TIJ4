package com.github.frankkwok.tij4.interfaces;

/**
 * Page 254
 * Exercise 14: Create three interfaces, each with two methods. Inherit a new interface that combines the three, adding
 * a new method. Create a class by implementing the new interface and also inheriting from a concrete class. Now write
 * four methods, each of which takes one of the four interfaces as an argument. In main( ), create an object of your
 * class and pass it to each of the methods.
 * <p>
 * Page 255
 * Exercise 15: Modify the previous exercise by creating an abstract class and inheriting that into the derived class.
 *
 * @author Frank Kwok on 2017/4/12.
 */
public class ConcreteClassTest extends ConcreteClass implements InterD {
    public static void main(String[] args) {
        ConcreteClassTest cct = new ConcreteClassTest();
        acceptA(cct);
        acceptB(cct);
        acceptC(cct);
        acceptD(cct);
    }

    private static void acceptA(InterA a) {
        a.a();
    }

    private static void acceptB(InterB b) {
        b.b();
    }

    private static void acceptC(InterC c) {
        c.c();
    }

    private static void acceptD(InterD d) {
        d.d();
    }

    @Override
    public void a() {
        System.out.println("ConcreteClassTest.a()");
    }

    @Override
    public void b() {
        System.out.println("ConcreteClassTest.b()");
    }

    @Override
    public void c() {
        System.out.println("ConcreteClassTest.c()");
    }

    @Override
    public void d() {
        System.out.println("ConcreteClassTest.d()");
    }

    @Override
    void print() {
        System.out.println("ConcreteClassTest.print()");
    }
}

abstract class ConcreteClass {

    abstract void print();
}

interface InterA {
    void a();
}

interface InterB {
    void b();
}

interface InterC {
    void c();
}

interface InterD extends InterA, InterB, InterC {
    void d();
}
