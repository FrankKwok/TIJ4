package com.github.frankkwok.tij4.generics;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * Page 481
 * Exercise 17: Study the JDK documentation for EnumSet. You’ll see that there’s a clone( ) method defined. However, you
 * cannot clone( ) from the reference to the Set interface passed in Sets.java. Can you modify Sets.java to handle both
 * the general case of a Set interface as shown, and the special case of an EnumSet, using clone( ) instead of creating
 * a new HashSet?
 *
 * @author Frank Kwok on 2017/5/16.
 */
public class Sets {
    public static <T> Set<T> union(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }


    public static <T extends Enum<T>> EnumSet<T> union(EnumSet<T> a, EnumSet<T> b) {
        EnumSet<T> result = a.clone();
        result.addAll(b);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
        Set<T> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    public static <T extends Enum<T>> EnumSet<T> intersection(EnumSet<T> a, EnumSet<T> b) {
        EnumSet<T> result = a.clone();
        a.removeAll(b);
        return result;
    }

    // Subtract subset from superset:
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
        Set<T> result = new HashSet<>(superset);
        result.removeAll(subset);
        return result;
    }

    public static <T extends Enum<T>> EnumSet<T> difference(EnumSet<T> a, EnumSet<T> b) {
        EnumSet<T> result = a.clone();
        result.removeAll(b);
        return result;
    }

    // Reflexive--everything not in the intersection:
    public static <T> Set<T> complement(Set<T> a, Set<T> b) {
        return difference(union(a, b), intersection(a, b));
    }

    public static <T extends Enum<T>> EnumSet<T> complement(EnumSet<T> a, EnumSet<T> b) {
        return difference(union(a, b), intersection(a, b));
    }
}
