package com.github.frankkwok.tij4.util;

import java.util.Objects;

/**
 * @author Frank Kwok on 2017/5/16.
 */
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
    public final C third;

    public ThreeTuple(A first, B second, C third) {
        super(first, second);
        this.third = third;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ", " + third + ")";
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) {
            return false;
        }
        ThreeTuple<A, B, C> other = (ThreeTuple<A, B, C>) otherObject;
        return Objects.equals(third, other.third);
    }

    @Override
    public int hashCode() {
        return super.hashCode() * 31 + Objects.hashCode(third);
    }
}
