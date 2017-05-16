package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.typeinfo.pets.Cat;
import com.github.frankkwok.tij4.typeinfo.pets.Dog;
import com.github.frankkwok.tij4.typeinfo.pets.Mouse;
import com.github.frankkwok.tij4.typeinfo.pets.Pet;

/**
 * Page 463
 * Exercise 1: Use Holders with the typeinfo.pets library to show that a Holders that is specified to hold a base type
 * can also hold a derived type.
 * Exercise 2: Create a holder class that holds three objects of the same type, along with the methods to store and
 * fetch those objects and a constructor to initialize all three.
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class HolderTest {
    public static void main(String[] args) {
        Holder<Pet> petHolder = new Holder<>(new Cat());
        System.out.println(petHolder.get());

        HolderThree<Pet> petHolderThree = new HolderThree<>(new Cat(), new Dog(), new Mouse());
        System.out.println(petHolderThree.getT1());
        System.out.println(petHolderThree.getT2());
        System.out.println(petHolderThree.getT3());
    }
}

class Holder<T> {
    private T t;

    public Holder(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public void set(T t) {
        this.t = t;
    }
}

class HolderThree<T> {
    private T t1;
    private T t2;
    private T t3;

    public HolderThree(T t1, T t2, T t3) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }

    public T getT1() {
        return t1;
    }

    public void setT1(T t1) {
        this.t1 = t1;
    }

    public T getT2() {
        return t2;
    }

    public void setT2(T t2) {
        this.t2 = t2;
    }

    public T getT3() {
        return t3;
    }

    public void setT3(T t3) {
        this.t3 = t3;
    }
}
