package com.github.frankkwok.tij4.util;

import java.util.Objects;

/**
 * @author Frank Kwok on 2017/5/16.
 */
public class FiveTuple<A, B, C, D, E> extends FourTuple<A, B, C, D> {
    public final E fifth;

    public FiveTuple(A first, B second, C third, D fourth, E fifth) {
        super(first, second, third, fourth);
        this.fifth = fifth;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ", " + fourth + ", " + fifth + ")";
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) {
            return false;
        }
        FiveTuple<A, B, C, D, E> other = (FiveTuple<A, B, C, D, E>) otherObject;
        return Objects.equals(fifth, other.fifth);
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + Objects.hashCode(fifth);
    }
}
