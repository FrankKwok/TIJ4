package com.github.frankkwok.tij4.typeinfo.pets;

/**
 * Page 435
 * Exercise 11: Add Gerbil to the typeinfo.pets library and modify all the examples in this chapter to adapt to this
 * new class.
 *
 * @author Frank Kwok on 2017/5/10.
 */
public class Pet extends Individual {
    public Pet() {
    }

    public Pet(String name) {
        super(name);
    }

    public void speak() {
        System.out.println(this + ".speak");
    }
}
