package com.github.frankkwok.tij4.generics;

import com.github.frankkwok.tij4.util.FiveTuple;

/**
 * Page 466
 * Exercise 3 : Create and test a SixTuple generic.
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class SixTuple<A, B, C, D, E, F> extends FiveTuple<A, B, C, D, E> {
    public final F sixth;

    public SixTuple(A first, B second, C third, D fourth, E fifth, F sixth) {
        super(first, second, third, fourth, fifth);
        this.sixth = sixth;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ", " + fifth + ", " + sixth + ")";
    }
}
