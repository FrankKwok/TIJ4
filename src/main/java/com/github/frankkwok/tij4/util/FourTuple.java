package com.github.frankkwok.tij4.util;

import java.util.Objects;

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

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) {
            return false;
        }
        FourTuple<A, B, C, D> other = (FourTuple<A, B, C, D>) otherObject;
        return Objects.equals(fourth, other.fourth);
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + Objects.hashCode(fourth);
    }
}
