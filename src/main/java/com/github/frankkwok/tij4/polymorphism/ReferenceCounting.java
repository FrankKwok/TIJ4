package com.github.frankkwok.tij4.polymorphism;

/**
 * Page 231
 * Exercise 13: Add a finalize( ) method to ReferenceCounting.java to verify the termination condition (see the
 * Initialization & Cleanup chapter).
 *
 * @author Frank Kwok on 2017/4/11.
 */
public class ReferenceCounting {
    public static void main(String[] args) {
        Shared shared = new Shared();
        Composing[] composing = {new Composing(shared),
                new Composing(shared), new Composing(shared),
                new Composing(shared), new Composing(shared)};
        for (Composing c : composing)
            c.dispose();
        System.gc();
    }
}

class Shared {
    private int refcount = 0;
    private static long counter = 0;
    private final long id = counter++;

    Shared() {
        System.out.println("Creating " + this);
    }

    void addRef() {
        refcount++;
    }

    protected void dispose() {
        if (--refcount == 0)
            System.out.println("Disposing " + this);
    }

    @Override
    public String toString() {
        return "Shared " + id;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        if (refcount != 0) {
            System.out.println("Shared state is illegal");
        }
    }
}

class Composing {
    private Shared shared;
    private static long counter = 0;
    private final long id = counter++;

    Composing(Shared shared) {
        System.out.println("Creating " + this);
        this.shared = shared;
        this.shared.addRef();
    }

    protected void dispose() {
        System.out.println("disposing " + this);
        shared.dispose();
    }

    @Override
    public String toString() {
        return "Composing " + id;
    }
}
