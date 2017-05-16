package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.typeinfo.pets.*;
import com.github.frankkwok.tij4.util.FiveTuple;
import com.github.frankkwok.tij4.util.FourTuple;
import com.github.frankkwok.tij4.util.ThreeTuple;
import com.github.frankkwok.tij4.util.TwoTuple;

/**
 * Page 478
 * Exercise 15: Verify the previous statement.
 * Exercise 16: Add a SixTuple to Tuple.java, and test it in TupleTest2 .java.
 * <p>
 * Since java can inference more, we don't need Tuple.java
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class TupleTest2 {
    public static void main(String[] args) {
        System.out.println(new TwoTuple<>(new Cat(), new Cymric()));
        System.out.println(new ThreeTuple<>(new Cat(), new Cymric(), new Dog()));
        System.out.println(new FourTuple<>(new Cat(), new Cymric(), new Dog(), new EgyptianMau()));
        System.out.println(new FiveTuple<>(new Cat(), new Cymric(), new Dog(), new EgyptianMau(), new Gerbil()));
        System.out.println(new SixTuple<>(new Cat(), new Cymric(), new Dog(), new EgyptianMau(), new Gerbil(), new Hamster()));
    }
}
