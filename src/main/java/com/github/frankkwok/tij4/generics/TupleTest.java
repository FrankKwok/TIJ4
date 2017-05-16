package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.typeinfo.pets.*;

/**
 * Page 466
 * Exercise 3 : Create and test a SixTuple generic.
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class TupleTest {
    public static void main(String[] args) {
        System.out.println(new SixTuple<>(new Cat(), new Cymric(), new Dog(), new EgyptianMau(), new Gerbil(), new Hamster()));
    }
}
