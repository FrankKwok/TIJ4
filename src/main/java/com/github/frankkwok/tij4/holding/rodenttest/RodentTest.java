package com.github.frankkwok.tij4.holding.rodenttest;

import java.util.*;

/**
 * Page 310
 * Exercise 10: Change Exercise 9 in the Polymorphism chapter to use an ArrayList to hold the Rodents and an Iterator to
 * move through the sequence of Rodents.
 * <p>
 * Exercise 11: Write a method that uses an Iterator to step through a Collection and print the toString( ) of each
 * object in the container. Fill all the different types of Collections with objects and apply your method to each
 * container.
 *
 * @author Frank Kwok on 2017/5/8.
 */
public class RodentTest {
    public static void main(String[] args) {
        RodentShared rodentShared = new RodentShared();
        Rodent[] rodents = new Rodent[]{
                new Rodent(rodentShared),
                new Mouse(rodentShared),
                new Gerbil(rodentShared),
                new Hamster(rodentShared)
        };
        List<Rodent> rodentList = new ArrayList<>();
        Collections.addAll(rodentList, rodents);
        Iterator<Rodent> iterator = rodentList.iterator();
        while (iterator.hasNext()) {
            Rodent r = iterator.next();
            r.bite();
            r.dispose();
            System.out.println();
        }

        useIteratorPrint(rodentList.iterator());
        useIteratorPrint(new LinkedList<>(rodentList).iterator());
        useIteratorPrint(new HashSet<>(rodentList).iterator());
        useIteratorPrint(new LinkedHashSet<>(rodentList).iterator());
    }

    private static void useIteratorPrint(Iterator<?> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }
}

class Rodent {
    private RodentShared rs;

    Rodent(RodentShared rs) {
        this.rs = rs;
        rs.addRef();
    }

    void bite() {
        System.out.println("Rodent.bite()");
    }

    void dispose() {
        System.out.println("Rodent.dispose()");
        rs.dispose();
    }
}

class Mouse extends Rodent {
    Mouse(RodentShared rs) {
        super(rs);
    }

    @Override
    void bite() {
        System.out.println("Mouse.bite()");
    }

    @Override
    void dispose() {
        System.out.println("Mouse.dispose()");
        super.dispose();
    }
}

class Gerbil extends Rodent {
    Gerbil(RodentShared rs) {
        super(rs);
    }

    @Override
    void bite() {
        System.out.println("Gerbil.bite()");
    }

    @Override
    void dispose() {
        System.out.println("Gerbil.dispose()");
        super.dispose();
    }
}

class Hamster extends Rodent {
    Hamster(RodentShared rs) {
        super(rs);
    }

    @Override
    void bite() {
        System.out.println("Hamster.bite()");
    }

    @Override
    void dispose() {
        System.out.println("Hamster.dispose()");
        super.dispose();
    }
}

class RodentShared {
    private static int count = 0;
    private int sharedRef = 0;
    private int id = count++;

    RodentShared() {
        System.out.println("Create " + this);
    }

    void addRef() {
        sharedRef++;
    }

    void dispose() {
        if (--sharedRef == 0) {
            System.out.println("dispose " + this);
        }
    }

    @Override
    public String toString() {
        return "RodentShared " + id;
    }
}
