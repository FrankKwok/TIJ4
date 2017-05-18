package com.github.frankkwok.tij4.generics;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Page 552
 * Exercise 42: Create two separate classes, with nothing in common. Each class should hold a value, and at least have
 * methods that produce that value and perform a modification upon that value. Modify Functional.java so that it
 * performs functional operations on collections of your classes (these operations do not have to be arithmetic as they
 * are in Functional.java).
 *
 * @author Frank Kwok on 2017/5/18.
 */
public class Functional {
    public static <T> T reduce(Iterable<T> seq, Combiner<T> combiner) {
        Iterator<T> it = seq.iterator();
        if (it.hasNext()) {
            T result = it.next();
            while (it.hasNext())
                result = combiner.combine(result, it.next());
            return result;
        }
        return null;
    }

    public static <T> Collector<T> forEach(Iterable<T> seq, Collector<T> func) {
        for (T t : seq)
            func.function(t);
        return func;
    }

    public static <R, T> List<R> transform(Iterable<T> seq, UnaryFunction<R, T> func) {
        List<R> result = new ArrayList<>();
        for (T t : seq)
            result.add(func.function(t));
        return result;
    }

    public static <T> List<T> filter(Iterable<T> seq, UnaryPredicate<T> pred) {
        List<T> result = new ArrayList<>();
        for (T t : seq)
            if (pred.test(t))
                result.add(t);
        return result;
    }

    static class IntegerAdder implements Combiner<Integer> {
        public Integer combine(Integer x, Integer y) {
            return x + y;
        }
    }

    static class IntegerSubtracter implements Combiner<Integer> {
        public Integer combine(Integer x, Integer y) {
            return x - y;
        }
    }

    static class BigDecimalAdder implements Combiner<BigDecimal> {
        public BigDecimal combine(BigDecimal x, BigDecimal y) {
            return x.add(y);
        }
    }

    static class BigIntegerAdder implements Combiner<BigInteger> {
        public BigInteger combine(BigInteger x, BigInteger y) {
            return x.add(y);
        }
    }

    static class AtomicLongAdder implements Combiner<AtomicLong> {
        public AtomicLong combine(AtomicLong x, AtomicLong y) {
            return new AtomicLong(x.addAndGet(y.get()));
        }
    }

    static class BigDecimalUlp implements UnaryFunction<BigDecimal, BigDecimal> {
        public BigDecimal function(BigDecimal x) {
            return x.ulp();
        }
    }

    static class GreaterThan<T extends Comparable<T>> implements UnaryPredicate<T> {
        private T bound;

        public GreaterThan(T bound) {
            this.bound = bound;
        }

        public boolean test(T x) {
            return x.compareTo(bound) > 0;
        }
    }

    static class MultiplyingIntegerCollector implements Collector<Integer> {
        private Integer val = 1;

        public Integer function(Integer x) {
            val *= x;
            return val;
        }

        public Integer result() {
            return val;
        }
    }

    static class HasValue1Adder implements Combiner<HasValue1> {
        @Override
        public HasValue1 combine(HasValue1 x, HasValue1 y) {
            HasValue1 h = new HasValue1();
            h.setValue(x.getValue() + y.getValue());
            return h;
        }
    }

    static class HasValue1Subtracter implements Combiner<HasValue1> {
        @Override
        public HasValue1 combine(HasValue1 x, HasValue1 y) {
            HasValue1 h = new HasValue1();
            h.setValue(x.getValue() - y.getValue());
            return h;
        }
    }

    static class HasValue2Adder implements Combiner<HasValue2> {
        @Override
        public HasValue2 combine(HasValue2 x, HasValue2 y) {
            HasValue2 h = new HasValue2();
            h.setValue(x.getValue() + y.getValue());
            return h;
        }
    }

    static class HasValue2Subtracter implements Combiner<HasValue2> {
        @Override
        public HasValue2 combine(HasValue2 x, HasValue2 y) {
            HasValue2 h = new HasValue2();
            h.setValue(x.getValue() - y.getValue());
            return h;
        }
    }

    static class HasValueUF implements UnaryFunction<HasValue1, HasValue2> {
        @Override
        public HasValue1 function(HasValue2 x) {
            HasValue1 h = new HasValue1();
            h.setValue(x.getValue());
            return h;
        }
    }
}

interface Combiner<T> {
    T combine(T x, T y);
}

interface UnaryFunction<R, T> {
    R function(T x);
}

interface Collector<T> extends UnaryFunction<T, T> {
    T result();
}

interface UnaryPredicate<T> {
    boolean test(T x);
}

class HasValue1 {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

class HasValue2 {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
