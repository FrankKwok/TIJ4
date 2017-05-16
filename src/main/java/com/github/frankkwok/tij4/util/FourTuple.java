package com.github.frankkwok.tij4.util;

/**
 * @author Frank Kwok on 2017/5/16.
 */
public class FourTuple<A, B, C, D> extends ThreeTuple<A, B, C> {
    public final D fourth;

    public FourTuple(A first, B second, C third, D fourth) {
        super(first, second, third);
        this.fourth = fourth;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + "," + third + ", " + fourth + ")";
    }
}
