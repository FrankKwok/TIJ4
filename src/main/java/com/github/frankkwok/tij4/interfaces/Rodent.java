package com.github.frankkwok.tij4.interfaces;

/**
 * Page 244
 * Exercise 1: Modify Exercise 9 in the previous chapter so that Rodent is an abstract class. Make the methods of Rodent
 * abstract whenever possible.
 * <p>
 * Page 247
 * Exercise 7: Change Exercise 9 in the Polymorphism chapter so that Rodent is an interface.
 *
 * @author Frank Kwok on 2017/4/12.
 */
public interface Rodent {
    static void main(String[] args) {
        Rodent[] rodents = new Rodent[]{
                new Mouse(),
                new Gerbil(),
                new Hamster()
        };
        for (Rodent r : rodents) {
            r.bite();
        }
    }

    void bite();
}

class Mouse implements Rodent {
    @Override
    public void bite() {
        System.out.println("Mouse.bite()");
    }
}

class Gerbil implements Rodent {
    @Override
    public void bite() {
        System.out.println("Gerbil.bite()");
    }
}

class Hamster implements Rodent {
    @Override
    public void bite() {
        System.out.println("Hamster.bite()");
    }
}
