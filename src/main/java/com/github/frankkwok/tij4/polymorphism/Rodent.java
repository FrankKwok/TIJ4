package com.github.frankkwok.tij4.polymorphism;

/**
 * Page 224
 * Exercise 9: Create an inheritance hierarchy of Rodent: Mouse, Gerbil, Hamster, etc. In the base class, provide
 * methods that are common to all Rodents, and override these in the derived classes to perform different behaviors
 * depending on the specific type of Rodent. Create an array of Rodent, fill it with different specific types of
 * Rodents, and call your base-class methods to see what happens.
 * <p>
 * Page 230
 * Exercise 12: Modify Exercise 9 so that it demonstrates the order of initialization of the base classes and derived
 * classes. Now add member objects to both the base and derived classes and show the order in which their initialization
 * occurs during construction.
 * <p>
 * Page 232
 * Exercise 14: Modify Exercise 12 so that one of the member objects is a shared object with reference counting, and
 * demonstrate that it works properly.
 *
 * @author Frank Kwok on 2017/4/11.
 */
public class Rodent {
    private RodentShared rs;

    Rodent(RodentShared rs) {
        this.rs = rs;
        rs.addRef();
    }

    public static void main(String[] args) {
        RodentShared rodentShared = new RodentShared();
        Rodent[] rodents = new Rodent[]{
                new Rodent(rodentShared),
                new Mouse(rodentShared),
                new Gerbil(rodentShared),
                new Hamster(rodentShared)
        };
        for (Rodent r : rodents) {
            r.bite();
            r.dispose();
            System.out.println();
        }
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
