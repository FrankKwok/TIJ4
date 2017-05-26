package com.github.frankkwok.tij4.util;

import java.util.Objects;

/**
 * @author Frank Kwok on 2017/5/16.
 */
public class TwoTuple<A, B> implements Comparable<TwoTuple<A, B>> {
    public final A first;
    public final B second;

    public TwoTuple(A first, B second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || getClass() != otherObject.getClass()) {
            return false;
        }
        TwoTuple<A, B> other = (TwoTuple<A, B>) otherObject;
        return Objects.equals(first, other.first) && Objects.equals(second, other.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    // TODO compare TwoTuple ThreeTuple FourTuple FiveTuple
    @Override
    public int compareTo(TwoTuple<A, B> otherObject) {
        return 0;
    }
}
