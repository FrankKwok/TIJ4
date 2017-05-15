package com.github.frankkwok.tij4.typoinfo.pets;

/**
 * Page 435
 * Exercise 11: Add Gerbil to the typeinfo.pets library and modify all the examples in this chapter to adapt to this
 * new class.
 *
 * @author Frank Kwok on 2017/5/10.
 */
public class Individual implements Comparable<Individual> {
    private static long counter = 0;

    private final long id = counter++;
    private String name;

    public Individual() {
    }

    public Individual(String name) {
        this.name = name;
    }

    public long id() {
        return id;
    }

    @Override
    public boolean equals(Object otherObject) {
        // eg. this == otherObject
        if (super.equals(otherObject)) {
            return true;
        }
        if (!(otherObject instanceof Individual)) {
            return false;
        }
        Individual other = (Individual) otherObject;
        return id == other.id;
    }

    @Override
    public int hashCode() {
        return (int) (31 * id);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + (name == null ? "" : " " + name);
    }

    @Override
    public int compareTo(Individual other) {
        String first = getClass().getSimpleName();
        String otherFirst = getClass().getSimpleName();
        int firstCompare = first.compareTo(otherFirst);
        if (firstCompare != 0) {
            return firstCompare;
        }
        if (name != null && other.name != null) {
            int secondCompare = name.compareTo(other.name);
            if (secondCompare != 0) {
                return secondCompare;
            }
        }
        return Long.compare(id, other.id);
    }
}
